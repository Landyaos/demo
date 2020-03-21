package com.utopia.demo.dto;

public class PermissionParam {

    private Long id;
    private String name;
    private String resource;
    private String description;

    @Override
    public String toString() {
        return "PermissionParam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resource='" + resource + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public PermissionParam() {
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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
