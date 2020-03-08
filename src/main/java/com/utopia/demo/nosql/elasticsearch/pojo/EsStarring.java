package com.utopia.demo.nosql.elasticsearch.pojo;

import javax.persistence.Column;
import java.util.Date;

public class EsStarring {
    private Long id;

    private Date createdDate;

    private Date updatedDate;

    private String name;

    private String foreign_name;

    private String cover_url;

    private String douban_link;

    private String imdb_link;

    public EsStarring() {
    }

    @Override
    public String toString() {
        return "EsStarring{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", cover_url='" + cover_url + '\'' +
                ", douban_link='" + douban_link + '\'' +
                ", imdb_link='" + imdb_link + '\'' +
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
}

