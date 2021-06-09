package com.cinema.core.entity;

import java.util.Set;

public enum Role {
    ;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    private  final Set<Permission> permissions;

    /*
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return  getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
    */
}
