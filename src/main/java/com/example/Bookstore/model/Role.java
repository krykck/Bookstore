package com.example.Bookstore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    Permission.ADMIN_READ,
                    Permission.ADMIN_UPDATE,
                    Permission.ADMIN_DELETE,
                    Permission.ADMIN_CREATE,
                    Permission.MANAGER_READ,
                    Permission.MANAGER_UPDATE,
                    Permission.MANAGER_DELETE,
                    Permission.MANAGER_CREATE
            )),

    MANAGER(
            Set.of(
                    Permission.MANAGER_READ,
                    Permission.MANAGER_UPDATE,
                    Permission.MANAGER_DELETE,
                    Permission.MANAGER_CREATE));


    private final Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> (new SimpleGrantedAuthority(permission.getPermission())))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
