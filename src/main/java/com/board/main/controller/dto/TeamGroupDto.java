package com.board.main.controller.dto;


import com.board.main.domain.TeamGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamGroupDto {
    private Integer id;
    private String name;

    public static TeamGroupDto fromTeamGroup(TeamGroup teamGroup) {
        return new TeamGroupDto(
                teamGroup.getId(),
                teamGroup.getName()
        );
    }
}
