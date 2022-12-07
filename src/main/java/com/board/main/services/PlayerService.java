package com.board.main.services;

import com.board.main.domain.Player;
import com.board.main.domain.Team;
import com.board.main.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }


    public Player findPlayersByName(String name) {
        return playerRepository.findPlayersByName(name)
                .orElseThrow(() -> new IllegalStateException(
                        "Player with name " + name + " does not exists"
                ));
    }

    public Player findById(Integer id) {
        return playerRepository.findById(id).orElse(null);
    }

    public void addNewPlayer(Player player) {
        playerRepository.findPlayersByName(player.getName()).ifPresentOrElse(
                (team1) -> {
                    throw new IllegalStateException("Player name taken");
                },
                () -> {
                    playerRepository.save(player);
                });
    }

    public void deletePlayer(Long id) {
        boolean exists = playerRepository.existsById(Math.toIntExact(id));
        if (!exists) {
            throw new IllegalStateException("Player with id " + id + " does not exists");
        }
        playerRepository.deleteById(Math.toIntExact(id));
    }

    @Transactional
    public void updatePlayer(Long playerId, String name, Integer goals, Integer assists, Integer yellow_cards, Integer red_cards, Integer played_matches, Integer teamId) {
        Player player = playerRepository.findById(Math.toIntExact(playerId)).orElseThrow(() -> new IllegalStateException("Player with id " + playerId + " does not exists"));
        if (name != null && name.length() > 0 && !player.getName().equals(name)) {
            player.setName(name);
        }
        if (goals != null && goals > 0 && player.getGoals() != goals) {
            player.setGoals(goals);
        }
        if (assists != null && assists > 0 && player.getAssists() != assists) {
            player.setAssists(assists);
        }
        if (yellow_cards != null && yellow_cards > 0 && player.getYellow_cards() != yellow_cards) {
            player.setYellow_cards(yellow_cards);
        }
        if (red_cards != null && red_cards > 0 && player.getRed_cards() != red_cards) {
            player.setRed_cards(red_cards);
        }
        if (played_matches != null && played_matches > 0 && player.getPlayed_matches() != played_matches) {
            player.setPlayed_matches(played_matches);
        }

    }


    public Page<Player> findAll(PageRequest of) {
        return playerRepository.findAll(of);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Team findPlayersByTeamId(Integer id) {
        return playerRepository.findPlayersByTeamId(id);
    }
}
