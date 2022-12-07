package com.board.main.controller.dto;

import com.board.main.domain.Player;
import com.board.main.domain.TeamGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private int id;
    private String name;
    private int goals;
    private int assists;
    private int yellow_cards;
    private int red_cards;
    private int played_matches;
    private String picture;

    public static PlayerDto fromPlayer(Player player) {
        return new PlayerDto(
                player.getId(),
                player.getName(),
                player.getGoals(),
                player.getAssists(),
                player.getYellow_cards(),
                player.getRed_cards(),
                player.getPlayed_matches(),
                player.getPicture()
        );
    }
}