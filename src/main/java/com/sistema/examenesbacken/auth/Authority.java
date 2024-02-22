package com.sistema.examenesbacken.auth;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    // Esta funcion nos permite obtener los roles
    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.authority;
    }

}
