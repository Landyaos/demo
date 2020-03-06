package com.utopia.demo.entity.view;

import com.utopia.demo.entity.Movie;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import java.io.Serializable;

class MovieDirectorKey implements Serializable {
    Long movie_id;
    Long director_id;
}
@Entity
@Table(name = "movie_director")
@IdClass(MovieDirectorKey.class)
public class MovieDirectorMigration {
    @Id
    private Long movie_id;
    @Id
    private Long director_id;

    @Column
    private Integer ranking;

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Long getDirector_id() {
        return director_id;
    }

    public void setDirector_id(Long director_id) {
        this.director_id = director_id;
    }
}
