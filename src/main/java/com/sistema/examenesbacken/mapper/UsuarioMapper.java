package com.sistema.examenesbacken.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sistema.examenesbacken.model.UsuarioModel;

public class UsuarioMapper implements RowMapper<UsuarioModel> {

    @Override
    public UsuarioModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setUserName(rs.getString("USER_NAME"));
        usuario.setName(rs.getString("NAME"));
        usuario.setLastName(rs.getString("LAST_NAME"));
        usuario.setEnable(rs.getInt("ENABLE"));
        usuario.setPhone(rs.getInt("PHONE"));
        usuario.setEmail(rs.getString("EMAIL"));
        usuario.setProfile(rs.getString("PROFILE"));
        return usuario;
    }

}
