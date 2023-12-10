package com.sistema.examenes.sistemaexamenesbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UsuarioRolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    private UsuarioModel user;
    @ManyToOne(fetch = FetchType.EAGER)
    private RoleModel role;

    public UsuarioRolModel() {

    }

    public Long getUserRolId() {
        return this.userRolId;
    }

    public void setUserRolId(Long userRolId) {
        this.userRolId = userRolId;
    }

    public UsuarioModel getUser() {
        return this.user;
    }

    public void setUser(UsuarioModel user) {
        this.user = user;
    }

    public RoleModel getRole() {
        return this.role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

}
