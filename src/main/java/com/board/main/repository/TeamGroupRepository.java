package com.board.main.repository;

import com.board.main.domain.Player;
import com.board.main.domain.TeamGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamGroupRepository extends JpaRepository<TeamGroup, Integer> {
    Optional<TeamGroup> findGroupByName(String name);
    Optional<TeamGroup> findById(Integer id);

    Page<TeamGroup> findAll(Pageable page);

    List<TeamGroup> findAll();
}

