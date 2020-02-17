package com.utopia.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column
    private String foreign_name;

    @Column
    private String area;
    @Column
    private String language;
    @Column
    private String cover;
    @Column
    private Long length;
    @Temporal(TemporalType.DATE)
    @Column
    private Date release_date;

    @Column
    private String url_douban;
    @Column
    private Float rate_douban;
    @Column
    private Long votes_douban;

    @Column
    private String url_imdb;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", area='" + area + '\'' +
                ", language='" + language + '\'' +
                ", cover='" + cover + '\'' +
                ", length=" + length +
                ", release_date=" + release_date +
                ", url_douban='" + url_douban + '\'' +
                ", rate_douban=" + rate_douban +
                ", votes_douban=" + votes_douban +
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getUrl_douban() {
        return url_douban;
    }

    public void setUrl_douban(String url_douban) {
        this.url_douban = url_douban;
    }

    public Float getRate_douban() {
        return rate_douban;
    }

    public void setRate_douban(Float rate_douban) {
        this.rate_douban = rate_douban;
    }

    public Long getVotes_douban() {
        return votes_douban;
    }

    public void setVotes_douban(Long votes_douban) {
        this.votes_douban = votes_douban;
    }

    public String getUrl_imdb() {
        return url_imdb;
    }

    public void setUrl_imdb(String url_imdb) {
        this.url_imdb = url_imdb;
    }
}
