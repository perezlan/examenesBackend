package com.sistema.examenesbacken.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioModel {
    private String userName;
    private String name;
    private String lastName;
    private int enable;
    private int phone;
    private String email;
    private String profile;

}
