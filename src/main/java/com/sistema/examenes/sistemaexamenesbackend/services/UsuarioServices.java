package com.sistema.examenes.sistemaexamenesbackend.services;

import java.util.Set;

import com.sistema.examenes.sistemaexamenesbackend.entidades.Usuario;
import com.sistema.examenes.sistemaexamenesbackend.entidades.UsuarioRol;

public interface UsuarioServices {
    Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles);

    Usuario ObtenerUsuario(String userName);

    void eliminarUsuario(Long id);
}
