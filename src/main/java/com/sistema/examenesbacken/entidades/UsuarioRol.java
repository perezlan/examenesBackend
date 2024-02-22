package com.sistema.examenesbacken.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UsuarioRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    public UsuarioRol() {

    }

    public Long getUserRolId() {
        return this.userRolId;
    }

    public void setUserRolId(Long userRolId) {
        this.userRolId = userRolId;
    }

    public Usuario getUser() {
        return this.user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
