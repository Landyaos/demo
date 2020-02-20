package com.utopia.demo.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;

@ApiModel(value = "Table_角色")
@Entity
@Table(name = "role")
public class Role extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany
    private Set<Permission> permissionSet;

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Set<Permission> getPermissionSet() {
        return permissionSet;
    }

    public void setPermissionSet(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
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
}
