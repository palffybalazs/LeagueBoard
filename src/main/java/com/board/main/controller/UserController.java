package com.board.main.controller;


import com.board.main.controller.dto.PlayerDto;
import com.board.main.controller.dto.TeamDto;
import com.board.main.domain.Player;
import com.board.main.domain.Team;
import com.board.main.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/users")
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public void getUser() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Big nono");
    }

    @Secured("ROLE_ADMIN")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/{id}", produces = APPLICATION_JSON_VALUE)
    public PlayerDto findPlayerByUserId(@PathVariable("id") int id) {
        if(id > 2){
            Player player = customUserDetailsService.findPlayerByUserId(id);
            return PlayerDto.fromPlayer(player);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No resource found");
        }
    }


}
