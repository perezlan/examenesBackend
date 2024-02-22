package com.sistema.examenesbacken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenesbacken.auth.JwtRequest;
import com.sistema.examenesbacken.auth.JwtResponse;
import com.sistema.examenesbacken.conf.JwtUtil;
import com.sistema.examenesbacken.services.implement.UserDetailsServiceImpl;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            autenticar(jwtRequest.getUserName(), jwtRequest.getPassword());

        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Incorrect username or password", e);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUserName());
        String token = this.jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            // TODO: handle exception
            throw new Exception("La cuenta del usuario está deshabilitada");
        } catch (BadCredentialsException e) {
            throw new Exception("Usuario o contraseña incorrectos");
        }

    }
}
