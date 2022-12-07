package com.board.main.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private int goals;
    private int assists;
    private int yellow_cards;
    private int red_cards;
    private int played_matches;

    private String picture;



    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;




    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
    private List<User> users;



    public Player(int id, String name, int goals, int assists, int yellow_cards, int red_cards, int played_matches) {
        this.id = id;
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.played_matches = played_matches;

    }

    public Player() {

    }
}
