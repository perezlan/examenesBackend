package com.sistema.examenesbacken.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenesbacken.entidades.Usuario;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUserName(String userName);

    void deleteById(Long id);
}