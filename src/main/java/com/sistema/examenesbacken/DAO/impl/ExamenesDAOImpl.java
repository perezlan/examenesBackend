package com.sistema.examenesbacken.DAO.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sistema.examenesbacken.DAO.ExamenesDAO;
import com.sistema.examenesbacken.entidades.Usuario;
import com.sistema.examenesbacken.mapper.UsuarioMapper;
import com.sistema.examenesbacken.model.UsuarioModel;

import jakarta.annotation.PostConstruct;

@Repository
public class ExamenesDAOImpl extends JdbcDaoSupport implements ExamenesDAO {

    @Autowired
    public ExamenesDAOImpl(DataSource dataSource) {

        super.setDataSource(dataSource);
    }

    @Override
    public List<UsuarioModel> getUser(String userName) {
        List<UsuarioModel> usuario;
        try {
            SimpleJdbcCall buscarUsuarioJdbcCall;
            buscarUsuarioJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                    .withProcedureName("SP_FINDUSER_EXAMEN")
                    .returningResultSet("pCursor", new UsuarioMapper());

            SqlParameterSource in = new MapSqlParameterSource().addValue("userName", userName);
            Map<String, Object> result = buscarUsuarioJdbcCall.execute(in);

            usuario = (List<UsuarioModel>) result.get("pCursor");
        } catch (Exception e) {
            usuario = null;
        }
        return usuario;
    }

}
