package com.board.main.controller;


import com.board.main.controller.dto.PlayerDto;
import com.board.main.controller.dto.TeamDto;
import com.board.main.domain.Team;
import com.board.main.domain.TeamGroup;
import com.board.main.services.PlayerService;
import com.board.main.domain.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/{id}", produces = APPLICATION_JSON_VALUE)
    public PlayerDto findById(@PathVariable("id") Integer id) {
        Player player = playerService.findById(id);
        return PlayerDto.fromPlayer(player);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/player/{name}", produces = APPLICATION_JSON_VALUE)
    public PlayerDto findPlayersByName(@PathVariable("name") String name) {
        Player player = playerService.findPlayersByName(name);
        return PlayerDto.fromPlayer(player);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/team/{team_id}", produces = APPLICATION_JSON_VALUE)
    public List<PlayerDto> findPlayersByTeamId(@PathVariable("team_id") int team_id) {
        Team team = playerService.findPlayersByTeamId(team_id);
        List<PlayerDto> playerDtos = new ArrayList<>();
        for(Player player : team.getPlayers()) {
            playerDtos.add(PlayerDto.fromPlayer(player));
        }
        return playerDtos;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<PlayerDto> getPlayers(@RequestParam(required = false, defaultValue = "100") Integer limit,
                               @RequestParam(required = false, defaultValue = "desc") String sort) {
        log.info("Calling GET /players endpoint.");

        if ( !sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc") ) {
            throw new IllegalArgumentException("Invalid sorting param!!!");
        }
        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, "goals") : Sort.by(Sort.Direction.DESC, "goals");

        Page<Player> players = playerService.findAll(PageRequest.of(0, limit, sortParam ));
        List<PlayerDto> playerDtos = new ArrayList<>();;
        for(Player player : players) {
            playerDtos.add(PlayerDto.fromPlayer(player));
        }
        return playerDtos;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/add/{player}")
    public PlayerDto addPlayer(@PathVariable("player") Player player) {
        log.info("Calling POST /players/add endpoint.");
        Player player1 = playerService.addPlayer(player);
        return PlayerDto.fromPlayer(player1);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/delete/{playerId}")
    public void deletePlayer(@PathVariable("playerId") Long playerId) {
        playerService.deletePlayer(playerId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/update/{playerId}")
    public void updateTeam(
            @PathVariable("playerId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer goals,
            @RequestParam(required = false) Integer assists,
            @RequestParam(required = false) Integer yellow_cards,
            @RequestParam(required = false) Integer red_cards,
            @RequestParam(required = false) Integer played_matches,
            @RequestParam(required = false) Integer teamId) {
        playerService.updatePlayer(id, name, goals, assists, yellow_cards, red_cards, played_matches, teamId);
    }
}
