package com.board.main.repository;

import com.board.main.domain.Player;
import com.board.main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    @Query("select b from Player b where b.id = :player_id")
    Player findPlayerByUserId(int player_id);
}
