package com.utopia.demo.entity.view;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review_migration")
@IdClass(Key.class)
public class ReviewMigration {

    @Id
    @Column
    private Long user;
    @Id
    @Column
    private Long movie;

    @Column
    private String title;

    @Column
    private Date date;

    @Column(columnDefinition = "text")
    private String content;

    @Column
    private Float rate;

    @Column
    private Long votes;

    @Override
    public String toString() {
        return "ReviewMigration{" +
                "user=" + user +
                ", movie=" + movie +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", rate=" + rate +
                ", votes=" + votes +
                '}';
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getMovie() {
        return movie;
    }

    public void setMovie(Long movie) {
        this.movie = movie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
