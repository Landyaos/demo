package com.utopia.demo.nosql.elasticsearch.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utopia.demo.entity.DirectorScreenwriter;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.Starring;
import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@ApiModel(value = "Index_电影")
@Document(indexName = "movie", type = "_doc")
public class EsMovie implements Serializable {
    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String foreign_name;

    @Field(type = FieldType.Text)
    private String profile;

    @Field(type = FieldType.Integer)
    private Integer length;

    @Field(type = FieldType.Text)
    private String language;

    @Field(type = FieldType.Keyword)
    private String area;

    @Field(type = FieldType.Date)
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd",timezone ="GMT+8")
    private Date release_date;

    @Field(type = FieldType.Float)
    private Float box_office;

    @Field(type = FieldType.Keyword)
    private String cover_url;

    @Field(type = FieldType.Float)
    private Float rate;

    @Field(type = FieldType.Long)
    private Long votes;

    @Field(type = FieldType.Keyword)
    private String rate_weight;

    @Field(type = FieldType.Keyword)
    private String imdb_link;

    @Field(type = FieldType.Keyword)
    private String douban_link;

    @Field(type = FieldType.Keyword)
    private String rottenTomatoes_link;

    @Field(type = FieldType.Object)
    private Set<DirectorScreenwriter> directorSet;

    @Field(type = FieldType.Object)
    private Set<DirectorScreenwriter> screenwriterSet;

    @Field(type = FieldType.Object)
    private Set<Starring> starringSet;

    @Field(type = FieldType.Object)
    private Set<Genre> genreSet;

    public EsMovie() {

    }

    @Override
    public String toString() {
        return "EsMovie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foreign_name='" + foreign_name + '\'' +
                ", profile='" + profile + '\'' +
                ", length=" + length +
                ", language='" + language + '\'' +
                ", area='" + area + '\'' +
                ", release_date=" + release_date +
                ", box_office=" + box_office +
                ", cover_url='" + cover_url + '\'' +
                ", rate=" + rate +
                ", votes=" + votes +
                ", rate_weight='" + rate_weight + '\'' +
                ", imdb_link='" + imdb_link + '\'' +
                ", douban_link='" + douban_link + '\'' +
                ", rottenTomatoes_link='" + rottenTomatoes_link + '\'' +
                ", directorSet=" + directorSet +
                ", screenwriterSet=" + screenwriterSet +
                ", starringSet=" + starringSet +
                ", genreSet=" + genreSet +
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    public String getImdb_link() {
        return imdb_link;
    }

    public void setImdb_link(String imdb_link) {
        this.imdb_link = imdb_link;
    }

    public String getDouban_link() {
        return douban_link;
    }

    public void setDouban_link(String douban_link) {
        this.douban_link = douban_link;
    }

    public String getRottenTomatoes_link() {
        return rottenTomatoes_link;
    }

    public void setRottenTomatoes_link(String rottenTomatoes_link) {
        this.rottenTomatoes_link = rottenTomatoes_link;
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

    public Set<Genre> getGenreSet() {
        return genreSet;
    }

    public void setGenreSet(Set<Genre> genreSet) {
        this.genreSet = genreSet;
    }
}
