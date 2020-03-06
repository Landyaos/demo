package com.utopia.demo.entity.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

class MovieGenreKey implements Serializable {
    Long movie_id;
    Long genre_id;
}

@Entity
@Table(name = "movie_genre_migration")
@IdClass(MovieGenreKey.class)
public class MovieGenreMigration {

    @Id
    private Long movie_id;

    @Id
    private Long genre_id;

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }
}
