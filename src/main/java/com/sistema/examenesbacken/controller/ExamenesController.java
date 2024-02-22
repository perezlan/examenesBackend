package com.sistema.examenesbacken.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.examenesbacken.DAO.impl.ExamenesDAOImpl;
import com.sistema.examenesbacken.entidades.Usuario;
import com.sistema.examenesbacken.model.UsuarioModel;

@RestController
@RequestMapping("/Examenes")
@CrossOrigin("*")
public class ExamenesController {
    private final ExamenesDAOImpl examenesDao;

    @Autowired
    public ExamenesController(ExamenesDAOImpl examenesDao) {
        this.examenesDao = examenesDao;
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable("userName") String userName) {

        try {
            List<UsuarioModel> usuario;
            usuario = (List<UsuarioModel>) examenesDao.getUser(userName);

            if (usuario == null || usuario.isEmpty()) {

                Map<String, Object> jsonResponse404 = new HashMap<>();
                jsonResponse404.put("userName", userName);
                jsonResponse404.put("error", "Usuario no encontrado");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonResponse404);
            }

            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch (Exception e) {

            Map<String, Object> jsonResponse500 = new HashMap<>();
            jsonResponse500.put("Error", "Error interno del servidor");
            // Devolver el objeto de error en el cuerpo de la respuesta con un código de
            // estado 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse500);
        }
    }
}
