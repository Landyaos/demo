package com.utopia.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_screenwriter_relation")
public class MovieScreenwriterRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL)
    private DirectorScreenwriter directorScreenwriter;

    @Column
    private Boolean isMaster;

    @Override
    public String toString() {
        return "MovieScreenwriterRelation{" +
                "id=" + id +
                ", movie=" + movie +
                ", directorScreenwriter=" + directorScreenwriter +
                ", isMaster=" + isMaster +
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

    public DirectorScreenwriter getDirectorScreenwriter() {
        return directorScreenwriter;
    }

    public void setDirectorScreenwriter(DirectorScreenwriter directorScreenwriter) {
        this.directorScreenwriter = directorScreenwriter;
    }

    public Boolean getMaster() {
        return isMaster;
    }

    public void setMaster(Boolean master) {
        isMaster = master;
    }

    public MovieScreenwriterRelation() {
    }
}
