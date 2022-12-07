package com.board.main.services;

import com.board.main.domain.Player;
import com.board.main.domain.User;
import com.board.main.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        User dbUser = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new
                        UsernameNotFoundException(String.format("User with username %s")));

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(dbUser.getUsername());
        System.out.println(dbUser.getPassword());

        return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password(dbUser.getPassword())
                .authorities(dbUser.getRole())
                .build();
    }


    public Player findPlayerByUserId(int id) {
        return userRepository.findPlayerByUserId(id);
    }
}