package ru.akkulov.service;

import lombok.Data;
import ru.akkulov.dao.TeamDAO;
import ru.akkulov.model.Team;
import ru.akkulov.model.Team.Names;

import java.util.List;

@Data
public class TeamService {
    private TeamDAO teamDAO;

    public TeamService() {
        teamDAO = new TeamDAO();
    }

    public void create(Team team) {
        teamDAO.create(team);
    }

    public List<Team> getAll() {
        return teamDAO.readAll();
    }

    public Team getById(int id) {
        return teamDAO.getById(id);
    }

    public void updateOne(int team_id, Names new_team_name) {
        teamDAO.updateOne(team_id, new_team_name);
    }

    public void deleteOne(int team_id) {
        teamDAO.deleteOne(team_id);
    }
}
