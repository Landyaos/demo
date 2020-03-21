package com.utopia.demo.dto;

import com.utopia.demo.entity.Permission;

import java.util.Set;

public class RoleParam {

    private Long id;
    private String name;
    private String description;
    private Set<Permission> permissions;


    public RoleParam() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
