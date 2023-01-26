package com.rishabh.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.login.entity.AuthRequest;
import com.rishabh.login.entity.User;
import com.rishabh.login.repository.UserRepository;
import com.rishabh.login.service.SequenceGeneratorService;
import com.rishabh.login.util.JwtUtil;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
	private SequenceGeneratorService service;
    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to javatechie !!";
    }
    
    @PostMapping("/signUp")
    public User signUp(@RequestBody User user)
    {
    	user.setId(service.getSequenceNumber(User.SEQUENCE_NAME));
    	return repository.save(user);
    	
    }
    

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}