package com.sistema.examenes.sistemaexamenesbackend.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.sistemaexamenesbackend.entidades.Role;
import com.sistema.examenes.sistemaexamenesbackend.entidades.Usuario;
import com.sistema.examenes.sistemaexamenesbackend.entidades.UsuarioRol;
import com.sistema.examenes.sistemaexamenesbackend.services.UsuarioServices;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        Set<UsuarioRol> roles = new HashSet<>();

        Role role = new Role();
        role.setId(2L);
        role.setName("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUser(usuario);
        usuarioRol.setRole(role);

        return usuarioServices.guardarUsuario(usuario, roles);
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
