package com.utopia.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;

@ApiModel(value = "Table_类型")
@Entity
@Table(name = "genre")
public class Genre extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column
    private String foreign_name;

    @Column
    private String description;

    /**
     * @ManyToMany(targetEntity = Parent.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     * @JoinTable(joinColumns = {@JoinColumn(name = "child_id")},
     * inverseJoinColumns = {@JoinColumn(name = "parent_id")})
     * private Set<Parent> parentSet;
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre_relation",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movieSet;


    public Genre() {
    }

    public Genre(String name, String foreign_name, String description) {
        this.name = name;
        this.foreign_name = foreign_name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Set<Movie> getMovieSet() {
        return movieSet;
    }

    @JsonBackReference
    public void setMovieSet(Set<Movie> movieSet) {
        this.movieSet = movieSet;
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
