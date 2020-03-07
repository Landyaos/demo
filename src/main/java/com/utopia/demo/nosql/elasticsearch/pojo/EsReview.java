package com.utopia.demo.nosql.elasticsearch.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utopia.demo.nosql.elasticsearch.dto.EsMovieParam;
import com.utopia.demo.nosql.elasticsearch.dto.EsUserParam;
import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.util.Date;

@ApiModel(value = "Index_影评")
@Document(indexName = "review",type = "_doc")
public class EsReview {
    @Id
    private Long id;

    @Field(type = FieldType.Object)
    private EsMovieParam esMovieParam;

    @Field(type = FieldType.Object)
    private EsUserParam esUserParam;

    @Field(type = FieldType.Text)
    private String title;


    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Date)
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd",timezone ="GMT+8")
    private Date date;

    @Field(type = FieldType.Float)
    private Float rate;

    @Field(type = FieldType.Long)
    private Long votes;

    @Override
    public String toString() {
        return "EsReview{" +
                "id=" + id +
                ", esMovieParam=" + esMovieParam +
                ", userParam=" + esUserParam +
                ", title='" + title + '\'' +
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

    public EsMovieParam getEsMovieParam() {
        return esMovieParam;
    }

    public void setEsMovieParam(EsMovieParam esMovieParam) {
        this.esMovieParam = esMovieParam;
    }

    public EsUserParam getEsUserParam() {
        return esUserParam;
    }

    public void setEsUserParam(EsUserParam esUserParam) {
        this.esUserParam = esUserParam;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
