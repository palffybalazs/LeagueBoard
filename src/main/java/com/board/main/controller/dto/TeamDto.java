package com.board.main.controller.dto;


import com.board.main.domain.Team;
import com.board.main.domain.TeamGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private Integer id;
    private String name;
    private int points;
    private int played_matches;

    public static TeamDto fromTeam(Team team) {
        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getPoints(),
                team.getPlayed_matches()
        );
    }
}
