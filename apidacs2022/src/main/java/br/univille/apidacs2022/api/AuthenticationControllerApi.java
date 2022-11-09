package br.univille.apidacs2022.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.apidacs2022.security.JWTUtil;
import br.univille.coredacs2022.entity.User;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationControllerApi {

    @Autowired
    private UserDetailsService serviceMyUserDetail;

    @Autowired
    private JWTUtil serviceJWT;
    private Logger logger = LoggerFactory.getLogger(AuthenticationControllerApi.class);

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody User user) {
        UserDetails userDetails = serviceMyUserDetail.loadUserByUsername(user.getUser());

        if (userDetails.getPassword().equals(user.getPassword())) {
            String token = serviceJWT.generateToken(userDetails);
            logger.info("Login successfully performed!!");
            return ResponseEntity.ok(token);
        }

        logger.error("Invalid user or password.");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    
}
