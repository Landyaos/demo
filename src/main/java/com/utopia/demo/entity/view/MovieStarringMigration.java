package com.utopia.demo.entity.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

class MovieStarringKey implements Serializable {
    Long movie_id;
    Long starring_id;
}

@Entity
@Table(name = "movie_starring_migration")
@IdClass(MovieStarringKey.class)
public class MovieStarringMigration {
    @Id
    private Long movie_id;
    @Id
    private Long starring_id;

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Long getStarring_id() {
        return starring_id;
    }

    public void setStarring_id(Long starring_id) {
        this.starring_id = starring_id;
    }
}
