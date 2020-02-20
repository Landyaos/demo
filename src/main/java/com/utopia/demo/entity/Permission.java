package com.utopia.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;

@ApiModel(value = "Table_权限")
@Entity
@Table(name = "permission")
public class Permission extends AbstractEntity {

    @Column
    private String name;

    @Column
    private  String description;

    @Column
    private String resource;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permission_relation",
            joinColumns = {@JoinColumn(name = "permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roleSet;

    public Permission() {
    }

    @Override
    public String toString() {
        return "Permission{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", resource='" + resource + '\'' +
                '}';
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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }
    @JsonBackReference
    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
