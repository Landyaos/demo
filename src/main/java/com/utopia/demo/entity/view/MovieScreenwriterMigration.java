package com.utopia.demo.entity.view;

import javax.persistence.*;
import java.io.Serializable;

class MovieScreenwriterKey implements Serializable {
    Long movie_id;
    Long screenwriter_id;

}
@Entity
@Table(name = "movie_screenwriter_migration")
@IdClass(MovieScreenwriterKey.class)
public class MovieScreenwriterMigration {
    @Id
    private Long movie_id;
    @Id
    private Long screenwriter_id;

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

    public Long getScreenwriter_id() {
        return screenwriter_id;
    }

    public void setScreenwriter_id(Long screenwriter_id) {
        this.screenwriter_id = screenwriter_id;
    }
}
