package com.utopia.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "director_screenwriter")
public class DirectorScreenwriter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column
    private String foreign_name;
    @Column
    private String cover;
    @Column
    private Boolean isDirector;
    @Column
    private Boolean isScreenwriter;
    @Column
    private String url_douban;
    @Column
    private String url_imdb;

    public DirectorScreenwriter() {

    }

    @Override
    public String toString() {
        return "DirectorScreenwriter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", cover='" + cover + '\'' +
                ", isDirector=" + isDirector +
                ", isScreenwriter=" + isScreenwriter +
                ", url_douban='" + url_douban + '\'' +
                ", url_imdb='" + url_imdb + '\'' +
                '}';
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

    public String getForeign_name() {
        return foreign_name;
    }

    public void setForeign_name(String foreign_name) {
        this.foreign_name = foreign_name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public String getUrl_douban() {
        return url_douban;
    }

    public void setUrl_douban(String url_douban) {
        this.url_douban = url_douban;
    }

    public String getUrl_imdb() {
        return url_imdb;
    }

    public void setUrl_imdb(String url_imdb) {
        this.url_imdb = url_imdb;
    }
}