package com.cinema.core.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permission.ADMIN_ADD_FILM,Permission.ADMIN_ADD_HALL,
            Permission.ADMIN_ADD_SESSION, Permission.ADMIN_REM_HALL,
            Permission.ADMIN_GET_ALL_FILMS,Permission.ADMIN_REM_SESSION,
            Permission.ADMIN_GET_ALL_SESSIONS,Permission.ADMIN_REM_FILM,
            Permission.ADMIN_UPDATE_FILM))
    ;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    private  final Set<Permission> permissions;


    public Set<SimpleGrantedAuthority> getAuthorities(){
        return  getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

}
