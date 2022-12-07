package com.board.main.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table
public class TeamGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teamGroup")
    private List<Team> teams;




    @Override
    public String toString() {
        return "TeamGroup{" +
                "id=" + id + " " + name + "}";
    }
}
