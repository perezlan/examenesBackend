package com.sistema.examenesbacken.services;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.sistema.examenesbacken.entidades.Usuario;
import com.sistema.examenesbacken.entidades.UsuarioRol;

public interface UsuarioServices {
    ResponseEntity<String> guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles);

    Usuario ObtenerUsuario(String userName);

    void eliminarUsuario(Long id);
}
