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

    @Override
    public Usuario ObtenerUsuario(String userName) {
        Usuario usuario = usuarioRepository.findByUserName(userName);
        try {

            if (usuario != null) {
                System.out.println("Se encontro el usuario: gg " + usuario.getUserName());
                System.out.println(usuario);
                return usuario;
            } else {
                System.out.println("No se encontro el usuario");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR AL OBTENER USUARIO " + e);
        } finally {
            return usuario;
        }

    }

    @Override
    public void eliminarUsuario(Long id) {
        // TODO Auto-generated method stub
        try {
            usuarioRepository.deleteById(id);
            System.out.println("USUARIO ELIMINADO!!");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR AL ELIMINAR EL USUARIO " + id);
        }

    }

}
