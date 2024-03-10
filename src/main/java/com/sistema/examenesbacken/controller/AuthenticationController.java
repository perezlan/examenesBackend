package com.sistema.examenesbacken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenesbacken.auth.JwtRequest;
import com.sistema.examenesbacken.auth.JwtResponse;
import com.sistema.examenesbacken.conf.JwtUtil;
import com.sistema.examenesbacken.services.implement.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private final JwtUtil jwtTokenUtil = new JwtUtil();

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println("*************** entro al controller");

        try {
            System.out.println("*************** entro al controller");
            autenticar(jwtRequest.getUserName(), jwtRequest.getPassword());

        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Incorrect username or password", e);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUserName());
        System.out.println("**********usuario CONTROLLER****** " + userDetails);
        String token = this.jwtTokenUtil.getToken(userDetails);
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
