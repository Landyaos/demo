package com.utopia.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review")
public class Review extends AbstractEntity{

    @OneToOne
    private User user;

    @OneToOne
    private Movie movie;

    @Column
    private String title;

    @Column
    private Float rate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column
    private Date date;

    @Column
    private Long votes;

    @Basic(fetch = FetchType.EAGER)
    @Column(columnDefinition = "text")
    private String content;

    @Override
    public String toString() {
        return "Review{" +
                "user=" + user +
                ", movie=" + movie +
                ", title='" + title + '\'' +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
