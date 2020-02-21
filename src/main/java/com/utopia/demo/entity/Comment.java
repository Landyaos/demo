package com.utopia.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

@ApiModel(value = "Table_评论")
@Entity
@Table(name = "comment")
public class Comment extends AbstractEntity{

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Movie movie;

    @Column
    private Float rate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column
    private Date date;

    @Column
    private Long votes;

    @Column(columnDefinition = "text")
    private String content;

    public Comment() {

    }

    @Override
    public String toString() {
        return "Comment{" +
                "user=" + user +
                ", movie=" + movie +
                ", rate=" + rate +
                ", date=" + date +
                ", votes=" + votes +
                ", content='" + content + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
