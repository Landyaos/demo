package com.utopia.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_starring_relation")
public class MovieStarringRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL)
    private Starrring starrring;


    public MovieStarringRelation() {
    }


    @Override
    public String toString() {
        return "MovieStarringRelation{" +
                "id=" + id +
                ", movie=" + movie +
                ", starrring=" + starrring +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Starrring getStarrring() {
        return starrring;
    }

    public void setStarrring(Starrring starrring) {
        this.starrring = starrring;
    }
}
