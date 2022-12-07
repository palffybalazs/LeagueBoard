package com.board.main.repository;

import com.board.main.domain.Player;
import com.board.main.domain.Team;
import com.board.main.domain.TeamGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    //SELECT * FROM team WHERE name = ?
    @Query("SELECT t FROM Team t WHERE t.name = ?1")
    Optional<Team> findTeamByName(String name);

    Page<Team> findAll(Pageable page);

    Optional<Team> findById(Integer id);




    @Query("select b from TeamGroup b where b.id = :team_group_id")
    TeamGroup findTeamsByGroupId(int team_group_id);
}

