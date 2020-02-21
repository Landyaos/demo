package com.utopia.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import org.apache.lucene.search.grouping.GroupFacetCollector;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@ApiModel(value = "Table_电影")
@Entity
@Table(name = "movie")
public class Movie extends AbstractEntity {

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column
    private Date release_date;

    @Column
    private Float box_office;

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

    @Column
    private String rottenTomatoes_link;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Genre> genreSet;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<DirectorScreenwriter> directorSet;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<DirectorScreenwriter> screenwriterSet;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Starring> starringSet;

    public Movie() {
    }
    public Movie(String name, Integer length, Date release_date, float rate, Set<DirectorScreenwriter> directorSet, Set<DirectorScreenwriter> screenwriterSet, Set<Starring> starringSet, Set<Genre> genreSet) {
        this.name = name;
        this.length = length;
        this.release_date = release_date;
        this.rate = rate;
        this.directorSet = directorSet;
        this.screenwriterSet = screenwriterSet;
        this.starringSet = starringSet;
        this.genreSet = genreSet;
    }

    public Movie(String name, Date date) {
        this.name = name;
        this.release_date = date;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", length=" + length +
                ", language='" + language + '\'' +
                ", area='" + area + '\'' +
                ", release_date=" + release_date +
                ", box_office=" + box_office +
                ", cover_url='" + cover_url + '\'' +
                ", rate=" + rate +
                ", votes=" + votes +
                ", rate_weight='" + rate_weight + '\'' +
                ", douban_link='" + douban_link + '\'' +
                ", imdb_link='" + imdb_link + '\'' +
                ", rottenTomatoes_link='" + rottenTomatoes_link + '\'' +
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

    public Float getBox_office() {
        return box_office;
    }

    public void setBox_office(Float box_office) {
        this.box_office = box_office;
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

    public String getRottenTomatoes_link() {
        return rottenTomatoes_link;
    }

    public void setRottenTomatoes_link(String rottenTomatoes_link) {
        this.rottenTomatoes_link = rottenTomatoes_link;
    }

    public Set<Genre> getGenreSet() {
        return genreSet;
    }

    public void setGenreSet(Set<Genre> genreSet) {
        this.genreSet = genreSet;
    }

    public Set<DirectorScreenwriter> getDirectorSet() {
        return directorSet;
    }

    public void setDirectorSet(Set<DirectorScreenwriter> directorSet) {
        this.directorSet = directorSet;
    }

    public Set<DirectorScreenwriter> getScreenwriterSet() {
        return screenwriterSet;
    }

    public void setScreenwriterSet(Set<DirectorScreenwriter> screenwriterSet) {
        this.screenwriterSet = screenwriterSet;
    }

    public Set<Starring> getStarringSet() {
        return starringSet;
    }

    public void setStarringSet(Set<Starring> starringSet) {
        this.starringSet = starringSet;
    }
}
