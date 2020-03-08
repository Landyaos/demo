package com.utopia.demo.nosql.elasticsearch.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utopia.demo.entity.Genre;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@Document(indexName = "demo",type = "_doc")
public class EsDemo implements Serializable {
    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String[] tags;

    public EsDemo() {
    }

    public EsDemo(Long id, String name, String[] tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "EsDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags=" + Arrays.toString(tags) +
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

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
