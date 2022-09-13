package com.db.springhello.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.db.springhello.models.Customer;
import com.db.springhello.models.User;
import com.db.springhello.services.JWTTokenService;
import com.db.springhello.services.UserService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;

@RestController()
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTTokenService jwtTokenService;

    @PostConstruct
    public void init() {
        System.out.println("UserController created");
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register(@RequestBody MultiValueMap<String, String> formData) {
        System.out.println("Test");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : formData.entrySet()) {
            sb.append(entry.getKey() + ": ");
            Iterator<String> valuesIterator = entry.getValue().iterator();
            while(valuesIterator.hasNext()) {
                sb.append(valuesIterator.next() + ", ");
            }
            sb.append("\n");
            System.out.println(sb.toString());
        }
        return "OK";
    }

    /**
     * Sets a Set-Cookie header on the response if the (username, password) pair matches an entry in the database.
     *
     * @param formData x-www-form-urlencoded form data with username and password keys set
     * @param response HttpServletResponse object to set headers for server response
     * @return The uid base64 encoded.
     */
    @PostMapping(path = "/auth", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(@RequestBody MultiValueMap<String, String> formData, HttpServletResponse response) {
        String username = formData.get("username").get(0);
        String password = formData.get("password").get(0);
        System.out.println("Got a login request with username " + username + " and password " + password);

        String uid = this.userService.getUID(username, password);
        if (uid != null) {
            System.out.println("User exists");
            ResponseCookie springCookie = ResponseCookie.from("uid", uid)
                    .path("/")
                    .domain("localhost")
                    .build();
            response.addHeader(HttpHeaders.SET_COOKIE, springCookie.toString());
//            return uid;
            return Base64.getEncoder().encodeToString(uid.getBytes());
        } else {
            System.err.println("User doesn't exist");
            return null;
        }
    }

    @PostMapping(path = "/authjwt", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String loginJwt(@RequestBody MultiValueMap<String, String> formData, HttpServletResponse response) {
        String username = formData.get("username").get(0);
        String password = formData.get("password").get(0);
        System.out.println("Got a login request (for JWT) with username " + username + " and password " + password);

        String uid = this.userService.getUID(username, password);
        if (uid != null) {
            User user = this.userService.uidExists(uid);
            if (user != null) {
                String jwtToken = this.userService.generateJwtToken(uid, user.role);
                return jwtToken;
            } else {
                System.err.println("User doesn't exist");
                return null;
            }
        } else {
            System.err.println("User doesn't exist");
            return null;
        }
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        // the previously generated jwt token must be invalidated/destroyed
        String jwtToken = this.jwtTokenService.extractToken(request);
        System.out.println("UID (basic auth) = " + jwtToken);
        if (jwtToken == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return null;
        }
        // query where uid
        DecodedJWT decodedJWT = this.jwtTokenService.decodeToken(jwtToken);
        if (!this.jwtTokenService.verifyToken(decodedJWT)) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return null;
        }
        User user = this.userService.uidExists(decodedJWT.getSubject());
        System.out.println(user);
        if (user == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return null;
        }
        // set expire time to now
        // generate new token
        // the client should "save" the new token and "forget" to old one
        jwtToken = this.userService.generateJwtToken(decodedJWT.getSubject(), 0, 0); // fake token
        System.out.println("Generated new expired token for the client to replace the old one: " + jwtToken);
        return jwtToken;

    }

}
