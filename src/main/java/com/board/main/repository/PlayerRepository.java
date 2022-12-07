package com.board.main.repository;

import com.board.main.domain.Player;
import com.board.main.domain.Team;
import com.board.main.domain.TeamGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findPlayersByName(String playername);

    List<Player> findAll();

    Page<Player> findAll(Pageable page);
    Optional<Player> findById(Integer id);

    @Query("select b from Team b where b.id = :team_id")
    Team findPlayersByTeamId(int team_id);

}
