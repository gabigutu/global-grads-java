package com.db.springhello.services;

import com.auth0.jwt.JWTCreator;
import com.db.springhello.models.User;
import com.db.springhello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTTokenService jwtTokenService;

    public String getUID(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            return user.uid;
        }
        return null;
    }

    public User uidExists(String uid) {
        return this.userRepository.findByUid(uid);
    }

    public String generateJwtToken(String uid) {
        JWTCreator.Builder jwtBuilder = this.jwtTokenService.generateToken();
        return this.jwtTokenService.signToken(jwtBuilder.withSubject(uid));
    }

    public String generateJwtToken(String uid, int expireDays) {
        JWTCreator.Builder jwtBuilder = this.jwtTokenService.generateToken(expireDays);
        return this.jwtTokenService.signToken(jwtBuilder.withSubject(uid));
    }

}
