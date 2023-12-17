package com.sistema.examenes.sistemaexamenesbackend;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistema.examenes.sistemaexamenesbackend.entidades.Role;
import com.sistema.examenes.sistemaexamenesbackend.entidades.Usuario;
import com.sistema.examenes.sistemaexamenesbackend.entidades.UsuarioRol;
import com.sistema.examenes.sistemaexamenesbackend.repository.UsuarioRepository;
import com.sistema.examenes.sistemaexamenesbackend.services.UsuarioServices;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioServices usuarioServices;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Usuario usuario = new Usuario();
		// usuario.setName("Mario");
		// usuario.setLastName("Landeros");
		// usuario.setUserName("PEREZLAN");
		// usuario.setPassword("123456");
		// usuario.setEmail("mario1999345@gmail.com");
		// usuario.setPhone("8129510730");
		// usuario.setProfile("foto.png");
		//
		// Role role = new Role();
		// role.setName("ADMIN");
		// role.setId(1L);
		//
		// Set<UsuarioRol> usuarioRoles = new HashSet<>();
		//
		// UsuarioRol usuarioRol = new UsuarioRol();
		// usuarioRol.setRole(role);
		// usuarioRol.setUser(usuario);
		//
		// usuarioRoles.add(usuarioRol);
		//
		// Usuario usuarioSaved = usuarioServices.guardarUsuario(usuario, usuarioRoles);
		//
		//// System.out.println("Usuario guardado: " + usuario.getUserName());
		// Usuario usuarioBuscado = usuarioServices.ObtenerUsuario("PEREZLA");
		// usuarioServices.eliminarUsuario("PEREZLAN");
	}

}
