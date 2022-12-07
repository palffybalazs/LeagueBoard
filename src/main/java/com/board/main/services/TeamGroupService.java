package com.board.main.services;

import com.board.main.domain.TeamGroup;
import com.board.main.repository.TeamGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class TeamGroupService {
    private final TeamGroupRepository teamGroupRepository;
    @Autowired
    public TeamGroupService(TeamGroupRepository teamGroupRepository) {
        this.teamGroupRepository = teamGroupRepository;
    }

    public List<TeamGroup> getGroups() {
        return teamGroupRepository.findAll();
    }

    public void addNewGroup(TeamGroup teamGroup) {
        teamGroupRepository.findGroupByName(teamGroup.getName()).ifPresentOrElse(
                (team1) -> {
                    throw new IllegalStateException("Group name taken");
                },
                () -> {
                    teamGroupRepository.save(teamGroup);
                });
    }

    public void deleteGroup(Long teamGroupId) {
        boolean exists = teamGroupRepository.existsById(Math.toIntExact(teamGroupId));
        if (!exists) {
            throw new IllegalStateException("Group with id " + teamGroupId + " does not exists");
        }
        teamGroupRepository.deleteById(Math.toIntExact(teamGroupId));
    }

    @Transactional
    public void updateGroup(Long id, String name) {
        TeamGroup teamGroup = teamGroupRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new IllegalStateException("Team with id " + id + " does not exists"));
        if (name != null && name.length() > 0 && !teamGroup.getName().equals(name)) {
            teamGroup.setName(name);
        }
    }
    public List<TeamGroup> findAll() {
        return teamGroupRepository.findAll();
    }


    public Page<TeamGroup> findAll(PageRequest of) {
        return teamGroupRepository.findAll(of);
    }

    public TeamGroup findTeamGroupsByName(String name) {
        return teamGroupRepository.findGroupByName(name).orElseThrow(() -> new IllegalStateException("Teamgroup with name " + name + " does not exists"));
    }

    public TeamGroup findTeamGroupsById(Integer id) {
        return teamGroupRepository.findById(id).orElseThrow(() -> new IllegalStateException("Teamgroup with id " + id + " does not exists"));
    }
}
