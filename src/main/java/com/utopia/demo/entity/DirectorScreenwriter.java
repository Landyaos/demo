package com.utopia.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;

@ApiModel(value = "Table_导演&编剧")
@Entity
@Table(name = "director_screenwriter")
public class DirectorScreenwriter extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String foreign_name;

    @Column
    private String cover_url;

    @Column
    private Boolean isDirector;

    @Column
    private Boolean isScreenwriter;

    @Column
    private String douban_link;

    @Column
    private String imdb_link;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_director_relation",
            joinColumns = {@JoinColumn(name = "director_screenwriter_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movieOfDirectorSet;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_screenwriter_relation",
            joinColumns = {@JoinColumn(name = "director_screenwriter_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movieOfScreenwriterSet;

    public DirectorScreenwriter() {

    }

    public DirectorScreenwriter(String name, String foreign_name, String cover_url, Boolean isDirector, Boolean isScreenwriter, String douban_link, String imdb_link) {
        this.name = name;
        this.foreign_name = foreign_name;
        this.cover_url = cover_url;
        this.isDirector = isDirector;
        this.isScreenwriter = isScreenwriter;
        this.douban_link = douban_link;
        this.imdb_link = imdb_link;
    }

    @Override
    public String toString() {
        return "DirectorScreenwriter{" +
                "name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", cover='" + cover_url + '\'' +
                ", isDirector=" + isDirector +
                ", isScreenwriter=" + isScreenwriter +
                ", douban_link='" + douban_link + '\'' +
                ", imdb_link='" + imdb_link + '\'' +
                '}';
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

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover) {
        this.cover_url = cover;
    }

    public Boolean getDirector() {
        return isDirector;
    }

    public void setDirector(Boolean director) {
        isDirector = director;
    }

    public Boolean getScreenwriter() {
        return isScreenwriter;
    }

    public void setScreenwriter(Boolean screenwriter) {
        isScreenwriter = screenwriter;
    }

    public String getDouban_link() {
        return douban_link;
    }

    public void setDouban_link(String douban_link) {
        this.douban_link = douban_link;
    }

    public String getImdb_link() {
        return imdb_link;
    }

    public void setImdb_link(String imdb_link) {
        this.imdb_link = imdb_link;
    }

    public Set<Movie> getMovieOfDirectorSet() {
        return movieOfDirectorSet;
    }
    @JsonBackReference
    public void setMovieOfDirectorSet(Set<Movie> directorSet) {
        this.movieOfDirectorSet = directorSet;
    }

    public Set<Movie> getMovieOfScreenwriterSet() {
        return movieOfScreenwriterSet;
    }
    @JsonBackReference
    public void setMovieOfScreenwriterSet(Set<Movie> screenwriterSet) {
        this.movieOfScreenwriterSet = screenwriterSet;
    }
}