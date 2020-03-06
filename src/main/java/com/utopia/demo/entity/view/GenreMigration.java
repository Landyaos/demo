package com.utopia.demo.entity.view;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre_migration")
public class GenreMigration {
    @Id
    private String name;

    @Column
    private String description;

    @Column
    private String foreign_name;

    @Override
    public String toString() {
        return "GenreMigration{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
