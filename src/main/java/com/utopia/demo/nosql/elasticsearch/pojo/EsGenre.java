package com.utopia.demo.nosql.elasticsearch.pojo;

import javax.persistence.Column;
import java.util.Date;

public class EsGenre {

    private Long id;

    private Date createdDate;

    private Date updatedDate;

    private String name;

    private String foreign_name;

    private String description;

    public EsGenre() {

    }

    @Override
    public String toString() {
        return "EsGenre{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForeign_name() {
        return foreign_name;
    }

    public void setForeign_name(String foreign_name) {
        this.foreign_name = foreign_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
