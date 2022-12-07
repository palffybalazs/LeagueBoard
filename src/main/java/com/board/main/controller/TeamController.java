package com.board.main.controller;

import com.board.main.controller.dto.TeamDto;
import com.board.main.controller.dto.TeamGroupDto;
import com.board.main.domain.TeamGroup;
import com.board.main.services.TeamService;
import com.board.main.domain.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/teams")
public class TeamController {
    private final TeamService teamService;

    /*@GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/team/{name}", produces = APPLICATION_JSON_VALUE)
    public TeamDto findTeamByName(@PathVariable("name") String name) {
        Team team = teamService.findTeamsByName(name);
        return TeamDto.fromTeam(team);
    }




    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/group/{groupId}", produces = APPLICATION_JSON_VALUE)
    public List<TeamDto> findTeamsByGroup(@PathVariable("groupId") int team_group_id) {
        TeamGroup teamGroup = teamService.findTeamsByGroupId(team_group_id);
        List<TeamDto> teamDtos = new ArrayList<>();;
        for(Team team : teamGroup.getTeams()) {
            teamDtos.add(TeamDto.fromTeam(team));
        }
        return teamDtos;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/find/{id}", produces = APPLICATION_JSON_VALUE)
    public TeamDto getTeamById(@PathVariable("id") Integer id) {
        Team team = teamService.findById(id);
        return TeamDto.fromTeam(team);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<TeamDto> getTeams(@RequestParam(required = false, defaultValue = "100") Integer limit,
                                   @RequestParam(required = false, defaultValue = "desc") String sort) {
        log.info("Calling GET /teams endpoint.");

        if ( !sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc") ) {
            throw new IllegalArgumentException("Invalid sorting param!!!");
        }
        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, "points") : Sort.by(Sort.Direction.DESC, "points");

        Page<Team> teams = teamService.findAll(PageRequest.of(0, limit, sortParam ));

        List<TeamDto> teamDtos = new ArrayList<>();


        for(Team team : teams) {
            teamDtos.add(TeamDto.fromTeam(team));
        }
        return teamDtos;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(produces = APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getTeamsAsTxt() throws IOException {

        byte[] binaryData = FileCopyUtils.copyToByteArray((new ClassPathResource("static/teams.txt")).getInputStream());
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=teams.txt");

        ByteArrayResource resource = new ByteArrayResource(binaryData);

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(resource.contentLength())
                .contentType(APPLICATION_OCTET_STREAM)
                .body(resource);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public void addTeam(@RequestBody Team team) {
        teamService.addNewTeam(team);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/delete/{teamId}")
    public void deleteTeam(@PathVariable("teamId") Long teamId) {
        teamService.deleteTeam(teamId);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/update/{teamId}")
    public void updateTeam(
            @PathVariable("teamId") Integer id,
            @RequestBody(required = false)Team team) {
        String name = team.getName();
        int points = team.getPoints();
        int played_matches = team.getPlayed_matches();
        teamService.updateTeam(id, name, points, played_matches);
    }
}
