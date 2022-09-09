package com.db.springhello.controllers;

import com.db.springhello.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api/user")
public class UserController {


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

}
