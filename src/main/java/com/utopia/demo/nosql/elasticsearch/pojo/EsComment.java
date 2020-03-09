package com.utopia.demo.nosql.elasticsearch.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utopia.demo.nosql.elasticsearch.dto.EsMovieParam;
import com.utopia.demo.nosql.elasticsearch.dto.EsUserParam;
import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "Index_评论")
@Document(indexName = "comment",type = "_doc")
public class EsComment implements Serializable {

    @Id
    private Long id;

    @Field(type = FieldType.Object)
    private EsUserParam user;

    @Field(type = FieldType.Object)
    private EsMovieParam movie;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Date)
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd",timezone ="GMT+8")
    private Date date;

    @Field(type = FieldType.Float)
    private Float rate;

    @Field(type = FieldType.Long)
    private Long votes;

    public EsComment() {
    }

    @Override
    public String toString() {
        return "EsComment{" +
                "id=" + id +
                ", user=" + user +
                ", movie=" + movie +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", rate=" + rate +
                ", votes=" + votes +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EsUserParam getUser() {
        return user;
    }

    public void setUser(EsUserParam user) {
        this.user = user;
    }

    public EsMovieParam getMovie() {
        return movie;
    }

    public void setMovie(EsMovieParam movie) {
        this.movie = movie;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
