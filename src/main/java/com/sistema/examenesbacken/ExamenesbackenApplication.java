package com.sistema.examenesbacken;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import com.sistema.examenesbacken.entidades.Role;
import com.sistema.examenesbacken.entidades.Usuario;
import com.sistema.examenesbacken.entidades.UsuarioRol;
import com.sistema.examenesbacken.services.UsuarioServices;

@SpringBootApplication
public class ExamenesbackenApplication implements CommandLineRunner {

	@Autowired
	private UsuarioServices usuarioServices;

	public static void main(String[] args) {
		SpringApplication.run(ExamenesbackenApplication.class, args);
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
		// ResponseEntity<String> usuarioSaved = usuarioServices.guardarUsuario(usuario,
		// usuarioRoles);
		//
		// System.out.println("Usuario guardado: " + usuario.getUserName());
		// Usuario usuarioBuscado = usuarioServices.ObtenerUsuario("PEREZLA");
		// usuarioServices.eliminarUsuario("PEREZLAN");
	}
}
