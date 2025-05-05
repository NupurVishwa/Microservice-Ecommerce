package com.example.userservice.Security.models;

import com.example.userservice.Model.Role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;

//@JsonDeserialize
public class CustomGrantedAuthority implements GrantedAuthority
{
    public CustomGrantedAuthority(){}

    String authority;
    public CustomGrantedAuthority(Role role)
    {
        this.authority = role.getValue();
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
