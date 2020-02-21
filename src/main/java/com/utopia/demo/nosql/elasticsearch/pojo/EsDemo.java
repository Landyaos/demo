package com.utopia.demo.nosql.elasticsearch.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utopia.demo.entity.Genre;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.Set;

@Document(indexName = "demo",type = "_doc")
public class EsDemo {
    @Id
    private Long id;
    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Date)
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd",timezone ="GMT+8")
    private Date date;

    @Field(type = FieldType.Text)
    private String[] tags;

    @Field(type = FieldType.Object)
    private Set<Genre> genres;


    public EsDemo(Long id, String name, Date date, String[] tags, Set<Genre> genres) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tags = tags;
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

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
