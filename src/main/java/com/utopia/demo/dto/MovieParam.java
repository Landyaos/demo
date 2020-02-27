package com.utopia.demo.dto;

import com.utopia.demo.entity.DirectorScreenwriter;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.Starring;

import java.util.Date;
import java.util.Set;

public class MovieParam {

    private Long id;
    private String name;
    private String foreign_name;
    private Integer length;
    private String language;
    private String area;
    private Date release_date;
    private Float box_office;
    private String cover_url;
    private Float rate;
    private Long votes;
    private String rate_weight;
    private String douban_link;
    private String imdb_link;
    private String rottenTomatoes_link;
    private Set<Genre> genreSet;
    private Set<Starring> starringSet;
    private Set<DirectorScreenwriter> directorSet;
    private Set<DirectorScreenwriter> screenwriterSet;

    public MovieParam() {
    }

    public MovieParam(Long id, String name, String foreign_name, Integer length, String language, String area, Date release_date, Float box_office, String cover_url, Float rate, Long votes, String rate_weight, String douban_link, String imdb_link, String rottenTomatoes_link) {
        this.id = id;
        this.name = name;
        this.foreign_name = foreign_name;
        this.length = length;
        this.language = language;
        this.area = area;
        this.release_date = release_date;
        this.box_office = box_office;
        this.cover_url = cover_url;
        this.rate = rate;
        this.votes = votes;
        this.rate_weight = rate_weight;
        this.douban_link = douban_link;
        this.imdb_link = imdb_link;
        this.rottenTomatoes_link = rottenTomatoes_link;
    }

    @Override
    public String toString() {
        return "MovieParam{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public Set<Starring> getStarringSet() {
        return starringSet;
    }

    public void setStarringSet(Set<Starring> starringSet) {
        this.starringSet = starringSet;
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
}
