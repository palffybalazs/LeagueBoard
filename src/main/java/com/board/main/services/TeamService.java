package com.board.main.services;

import com.board.main.domain.Team;
import com.board.main.domain.TeamGroup;
import com.board.main.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class TeamService {
    private final TeamRepository teamRepository;
    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public void addNewTeam(Team team) {
        teamRepository.findTeamByName(team.getName()).ifPresentOrElse(
            (team1) -> {
                throw new IllegalStateException("Team name taken");
            },
            () -> {
                teamRepository.save(team);
            });
    }

    public void deleteTeam(Long teamId) {
        boolean exists = teamRepository.existsById(Math.toIntExact(teamId));
        if (!exists) {
            throw new IllegalStateException("Team with id " + teamId + " does not exists");
        }
        teamRepository.deleteById(Math.toIntExact(teamId));
    }

    @Transactional
    public void updateTeam(int id, String name, Integer points, Integer played_matches) {
        Team team = teamRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new IllegalStateException("Team with id " + id + " does not exists"));
        System.out.println("team: " + team.getName());
        System.out.println("name: " + name);
        if (name != null && name.length() > 0 && !team.getName().equals(name)) {
            team.setName(name);
        }
        if (points != null && points > 0 && team.getPoints() != points) {
            team.setPoints(points);
        }
        if (played_matches != null && played_matches > 0 && team.getPlayed_matches() != played_matches) {
            team.setPlayed_matches(played_matches);
        }
    }

    public Page<Team> findAll(PageRequest of) {
        return teamRepository.findAll(of);
    }

    public Team findTeamsByName(String name) {
        return teamRepository.findTeamByName(name).orElseThrow(() -> new IllegalStateException("Team with name " + name + " does not exists"));
    }

    public Team findById(Integer id) {
        return teamRepository.findById(id).orElseThrow(() -> new IllegalStateException("Team with id " + id + " does not exists"));
    }

    public TeamGroup findTeamsByGroupId(int team_group_id) {
        return teamRepository.findTeamsByGroupId(team_group_id);
    }



}
