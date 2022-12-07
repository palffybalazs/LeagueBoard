package com.board.main.controller;

import com.board.main.controller.dto.PlayerDto;
import com.board.main.controller.dto.TeamDto;
import com.board.main.controller.dto.TeamGroupDto;
import com.board.main.domain.Player;
import com.board.main.services.TeamGroupService;
import com.board.main.domain.TeamGroup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/teamgroups")
public class TeamGroupController {
    private final TeamGroupService teamGroupService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<TeamGroupDto> getTeamGroups() {
        List<TeamGroup> teamGroups = teamGroupService.findAll();
        List<TeamGroupDto> teamGroupsDto = new ArrayList<>();
        for(TeamGroup teamGroup : teamGroups) {
            teamGroupsDto.add(TeamGroupDto.fromTeamGroup(teamGroup));
        }
        return teamGroupsDto;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/group/{name}", produces = APPLICATION_JSON_VALUE)
    public TeamGroupDto findTeamGroupByName(@PathVariable("name") String name) {
        TeamGroup teamGroup = teamGroupService.findTeamGroupsByName(name);
        return TeamGroupDto.fromTeamGroup(teamGroup);
    }
    @Secured("ROLE_ADMIN")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/find/{id}", produces = APPLICATION_JSON_VALUE)
    public TeamGroupDto getTeamGroupById(@PathVariable("id") Integer id) {
        TeamGroup teamGroup = teamGroupService.findTeamGroupsById(id);
        return TeamGroupDto.fromTeamGroup(teamGroup);
    }


    /*@GetMapping
    public List<TeamGroup> getTeamGroups(@RequestParam(required = false, defaultValue = "100") Integer limit,
                               @RequestParam(required = false, defaultValue = "desc") String sort) {
        log.info("Calling GET /teamgroups endpoint.");

        if ( !sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc") ) {
            throw new IllegalArgumentException("Invalid sorting param!!!");
        }
        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, "teams.points") : Sort.by(Sort.Direction.DESC, "teams.points");

        Page<TeamGroup> teamGroups = teamGroupService.findAll(PageRequest.of(0, limit, sortParam ));

        return teamGroups.toList();
    }*/

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public void addTeam(@RequestBody TeamGroup teamGroup) {
        teamGroupService.addNewGroup(teamGroup);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/delete/{teamGroupId}")
    public void deleteTeam(@PathVariable("teamGroupId") Long teamGroupId) {
        teamGroupService.deleteGroup(teamGroupId);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/update/{teamGroupId}")
    public void updateTeam(
            @PathVariable("teamGroupId") Long id,
            @RequestParam(required = false) String name) {
        teamGroupService.updateGroup(id, name);
    }

}
