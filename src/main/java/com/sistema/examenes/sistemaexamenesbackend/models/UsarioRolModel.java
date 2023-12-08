package com.sistema.examenes.sistemaexamenesbackend.models;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class UsarioRolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRolId;

    @ManyToOne(fetch  = FetchType.EAGER)
    private UsuarioModel user;

    @ManyToOne(fetch  = FetchType.EAGER)
    private RoleModel role;
}
