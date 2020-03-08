package com.utopia.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.el.stream.StreamELResolverImpl;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "starring")
public class Starring extends AbstractEntity {

    @Column
    private String name;
    @Column
    private String foreign_name;
    @Column
    private String cover_url;
    @Column
    private String douban_link;
    @Column
    private String imdb_link;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_starring_relation",
            joinColumns = {@JoinColumn(name = "starring_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movieSet;

    public Starring() {
    }

    public Starring(Long id) {
        this.setId(id);
    }

    public Starring(String name, String foreign_name, String cover_url, String douban_link, String imdb_link) {
        this.name = name;
        this.foreign_name = foreign_name;
        this.cover_url = cover_url;
        this.douban_link = douban_link;
        this.imdb_link = imdb_link;
    }

    @Override
    public String toString() {
        return "Starring{" +
                "name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", cover_url='" + cover_url + '\'' +
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

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
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

    public Set<Movie> getMovieSet() {
        return movieSet;
    }

    public void setMovieSet(Set<Movie> movieSet) {
        this.movieSet = movieSet;
    }
}
