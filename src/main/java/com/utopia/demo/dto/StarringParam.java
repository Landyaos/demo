package com.utopia.demo.dto;

import javax.persistence.Column;

public class StarringParam {

    private Long id;
    private String name;
    private String foreign_name;
    private String cover_url;
    private String douban_link;
    private String imdb_link;

    public StarringParam() {

    }

    public StarringParam(Long id, String name, String foreign_name, String cover_url, String douban_link, String imdb_link) {
        this.id = id;
        this.name = name;
        this.foreign_name = foreign_name;
        this.cover_url = cover_url;
        this.douban_link = douban_link;
        this.imdb_link = imdb_link;
    }

    @Override
    public String toString() {
        return "StarringParam{" +
                "id=" + id +
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
