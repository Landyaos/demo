package com.utopia.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "role_permission_relation")
public class RolePermissionRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    private Permission permission;

    public RolePermissionRelation() {

    }

    public RolePermissionRelation(Role role, Permission permission) {
        this.role = role;
        this.permission = permission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
