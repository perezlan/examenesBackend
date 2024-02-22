package com.sistema.examenesbacken.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/Usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping("/")
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Role role = new Role();
        role.setId(2L);
        role.setName("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUser(usuario);
        usuarioRol.setRole(role);
        usuarioRoles.add(usuarioRol);
        ResponseEntity<String> respuesta = usuarioServices.guardarUsuario(usuario, usuarioRoles);
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
