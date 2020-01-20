package com.utopia.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_director_relation")
public class MovieDirectorRelation {

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
        return "MovieDirectorRelation{" +
                "id=" + id +
                ", movie=" + movie +
                ", directorScreenwriter=" + directorScreenwriter +
                ", isMaster=" + isMaster +
                '}';
    }

    public Boolean getMaster() {
        return isMaster;
    }

    public void setMaster(Boolean master) {
        isMaster = master;
    }

    public MovieDirectorRelation() {

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
}
