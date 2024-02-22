package com.sistema.examenesbacken.DAO;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sistema.examenesbacken.model.UsuarioModel;

public interface ExamenesDAO {
    List<UsuarioModel> getUser(String userName);
}
