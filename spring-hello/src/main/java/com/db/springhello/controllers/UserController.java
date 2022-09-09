package com.db.springhello.controllers;

import com.db.springhello.models.Customer;
import com.db.springhello.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

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
            return uid;
        } else {
            System.err.println("User doesn't exist");
            return null;
        }
    }

}
