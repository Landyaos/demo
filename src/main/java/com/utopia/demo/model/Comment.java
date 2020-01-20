package com.utopia.demo.model;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Movie movie;

    @Column
    private Long rate;
    @Column
    private String content;

    public Comment() {

    }


}
