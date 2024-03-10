package com.sistema.examenesbacken.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenesbacken.entidades.Role;
import com.sistema.examenesbacken.entidades.Usuario;
import com.sistema.examenesbacken.entidades.UsuarioRol;
import com.sistema.examenesbacken.services.UsuarioServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Usuario")
@CrossOrigin("*")
public class UsuarioController {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping("/")
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        Set<UsuarioRol> usuarioRoles = new HashSet<>();
        Usuario user = Usuario.builder()
                .name(usuario.getName())
                .lastName(usuario.getLastName())
                .password(passwordEncoder.encode(usuario.getPassword()))
                .email(usuario.getEmail())
                .username(usuario.getUsername())
                .phone(usuario.getPhone())
                .profile(usuario.getProfile())
                .build();

        Role role = new Role();
        role.setId(2L);
        role.setName("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUser(user);
        usuarioRol.setRole(role);
        usuarioRoles.add(usuarioRol);

        ResponseEntity<String> respuesta = usuarioServices.guardarUsuario(user, usuarioRoles);
        return respuesta;
    }

    @GetMapping("/{userName}")
    public Usuario obteneUsuario(@PathVariable("userName") String userName) throws Exception {

        return usuarioServices.ObtenerUsuario(userName);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) throws Exception {
        usuarioServices.eliminarUsuario(id);
    }
}
