package com.db.springhello.controllers;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.db.springhello.SpringHelloApplication;
import com.db.springhello.models.User;
import com.db.springhello.services.JWTTokenService;
import com.db.springhello.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Date;
import java.util.StringTokenizer;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTTokenService jwtTokenService;

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping("")
    public Object getOrdersWithCookie(@CookieValue(name = "uid", defaultValue = "-1") String uid) {
        System.out.println("UID = " + uid);
        if (uid.compareTo("-1") == 0) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // query where uid
        User user = this.userService.uidExists(uid);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return "{BUN venit , " + user.email + " de la cookie }";
    }

    @GetMapping("/basic")
    public Object getOrdersBasicAuth(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        StringTokenizer stringTokenizer = new StringTokenizer(authorization, " ");
        String authType, uid = "-1";
        if(stringTokenizer.hasMoreTokens()) {
            authType = stringTokenizer.nextToken(); // "Basic"
        }
        if(stringTokenizer.hasMoreTokens()) {
            uid = stringTokenizer.nextToken(); // uid
        }

        System.out.println("UID (basic auth) = " + uid);
        if (uid.compareTo("-1") == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // query where uid

        uid = new String(Base64.getDecoder().decode(uid));
        User user = this.userService.uidExists(uid);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return "{BUN venit, " + user.email + " de la BASIC AUTH";
    }

    @GetMapping("/jwt")
    public Object getOrdersJwtAuth(HttpServletRequest request) {
        String jwtToken = this.jwtTokenService.extractToken(request);
        System.out.println("UID (basic auth) = " + jwtToken);
        if (jwtToken == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // query where uid
        DecodedJWT decodedJWT = this.jwtTokenService.decodeToken(jwtToken);
        if (!this.jwtTokenService.verifyToken(decodedJWT)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = this.userService.uidExists(decodedJWT.getSubject());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return "{BUN venit, " + user.email + " de la BASIC AUTH}";
    }

    @GetMapping("/")
    public ResponseEntity getOrdersSlash( HttpServletRequest request) {
//        RequestMapping requestMappingAnnotation = this.getClass().getAnnotation(RequestMapping.class);
        String url = request.getServletPath().replaceAll("/$", "");
        System.out.println("URL = " + url);
        try {
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(new URI(url)).build();
        } catch (URISyntaxException e) {
            System.err.println("Cannot redirect to " + url);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
