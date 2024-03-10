package com.sistema.examenesbacken.services.implement;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistema.examenesbacken.entidades.Usuario;
import com.sistema.examenesbacken.entidades.UsuarioRol;
import com.sistema.examenesbacken.repository.RoleRepository;
import com.sistema.examenesbacken.repository.UsuarioRepository;
import com.sistema.examenesbacken.services.UsuarioServices;

@Service
public class UsuarioServicesImpl implements UsuarioServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity<String> guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal != null) {
            // Usuario ya existe
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Usuario ya existente\"}");
        } else {
            // Guardar roles
            for (UsuarioRol usuarioRol : usuarioRoles) {
                roleRepository.save(usuarioRol.getRole());
            }

            // Inicializar el conjunto de roles del usuario si es nulo
            if (usuario.getUserRoles() == null) {
                usuario.setUserRoles(new HashSet<>());
            }
            // Asignar roles al usuario
            usuario.getUserRoles().addAll(usuarioRoles);

            // Guardar usuario
            usuarioLocal = usuarioRepository.save(usuario);

            // Usuario guardado exitosamente
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"Usuario creado correctamente\"}");

        }
    }

    @Override
    public Usuario ObtenerUsuario(String userName) {
        Usuario usuario = usuarioRepository.findByUsername(userName);
        try {

            if (usuario != null) {
                System.out.println("Se encontro el usuario: gg " + usuario.getUsername());
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
