package com.utopia.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "movie_genre_relation")
public class MovieGenreRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL)
    private Genre genre;

    public MovieGenreRelation() {
    }

    public MovieGenreRelation(Movie movie, Genre genre) {
        this.movie = movie;
        this.genre = genre;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
