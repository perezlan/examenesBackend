package com.sistema.examenes.sistemaexamenesbackend.services.implement;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.sistemaexamenesbackend.entidades.Usuario;
import com.sistema.examenes.sistemaexamenesbackend.entidades.UsuarioRol;
import com.sistema.examenes.sistemaexamenesbackend.repository.RoleRepository;
import com.sistema.examenes.sistemaexamenesbackend.repository.UsuarioRepository;
import com.sistema.examenes.sistemaexamenesbackend.services.UsuarioServices;

@Service
public class UsuarioServicesImpl implements UsuarioServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) {
        Usuario usuarioLocal = usuarioRepository.findByUserName(usuario.getUserName());
        if (usuarioLocal != null) {
            System.out.println("Usuario ya existente!!!");
        } else {
            for (UsuarioRol usuarioRol : usuarioRoles) {
                roleRepository.save(usuarioRol.getRole());
            }
            usuario.getUserRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

}
