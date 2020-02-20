package com.utopia.demo.nosql.elasticsearch.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utopia.demo.entity.Genre;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Document(indexName = "demo",type = "_doc")
public class EsDemo {
    @Id
    private Long id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Date, format = DateFormat.custom,pattern ="yyyy-MM-dd")
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd",timezone ="GMT+8")
    private Date date;
    @Field(type = FieldType.Text)
    private String[] tag;

    @Field(type = FieldType.Auto)
    private Set<Genre> genres;


    public EsDemo(Long id, String name, Date date, String[] tag, Set<Genre> genres) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tag = tag;
        this.genres = genres;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
