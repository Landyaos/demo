package com.utopia.demo.entity.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "director_screenwriter_migration")
public class DirectorScreenwriterMigration {
    @Id
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

    @Override
    public String toString() {
        return "DirectorScreenwriterMigration{" +
                "name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", cover_url='" + cover_url + '\'' +
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

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
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
}
