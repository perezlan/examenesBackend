package com.sistema.examenes.sistemaexamenesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.sistemaexamenesbackend.entidades.Usuario;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUserName(String userName);

}