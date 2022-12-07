package com.board.main.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private int points;
    private int played_matches;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_group_id")
    private TeamGroup teamGroup;


    @JsonIgnore
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private List<Player> players;

    public Team(int id, String name, int points, int played_matches) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.played_matches = played_matches;
    }


    public Team(String name, int points, int played_matches) {
        this.name = name;
        this.points = points;
        this.played_matches = played_matches;
    }


    public int getPoints() {
        return points;
    }

    public Team() {

    }


}
