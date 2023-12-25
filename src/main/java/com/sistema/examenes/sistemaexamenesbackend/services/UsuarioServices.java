package com.sistema.examenes.sistemaexamenesbackend.services;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.sistema.examenes.sistemaexamenesbackend.entidades.Usuario;
import com.sistema.examenes.sistemaexamenesbackend.entidades.UsuarioRol;

public interface UsuarioServices {
    ResponseEntity<String> guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles);

    Usuario ObtenerUsuario(String userName);

    void eliminarUsuario(Long id);
}
