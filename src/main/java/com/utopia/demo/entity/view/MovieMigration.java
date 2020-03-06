package com.utopia.demo.entity.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie_migration")
public class MovieMigration {

    @Id
    @Column
    private String id_douban;

    @Column(nullable = false)
    private String name;

    @Column
    private String foreign_name;

    @Column
    private Integer length;

    @Column
    private String language;

    @Column
    private String area;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column
    private Date release_date;

    @Column
    private String cover_url;

    @Column
    private Float rate;

    @Column
    private Long votes;

    @Column
    private String rate_weight;

    @Column
    private String douban_link;

    @Column
    private String imdb_link;

    @Column(columnDefinition = "text")
    private String profile;

    @Override
    public String toString() {
        return "MovieMigration{" +
                "id_douban='" + id_douban + '\'' +
                ", name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", length=" + length +
                ", language='" + language + '\'' +
                ", area='" + area + '\'' +
                ", release_date=" + release_date +
                ", cover_url='" + cover_url + '\'' +
                ", rate=" + rate +
                ", votes=" + votes +
                ", rate_weight='" + rate_weight + '\'' +
                ", douban_link='" + douban_link + '\'' +
                ", imdb_link='" + imdb_link + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }

    public String getId_douban() {
        return id_douban;
    }

    public void setId_douban(String id_douban) {
        this.id_douban = id_douban;
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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public String getRate_weight() {
        return rate_weight;
    }

    public void setRate_weight(String rate_weight) {
        this.rate_weight = rate_weight;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
