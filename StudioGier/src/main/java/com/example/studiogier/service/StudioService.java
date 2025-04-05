package com.example.studiogier.service;

import com.example.studiogier.entity.Employees;
import com.example.studiogier.entity.Games;
import com.example.studiogier.entity.Teams;
import com.example.studiogier.repository.EmployeesRepository;
import com.example.studiogier.repository.GamesRepository;
import com.example.studiogier.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudioService {

    @Autowired
    private final GamesRepository gamesRepository;
    @Autowired
    private final EmployeesRepository employeesRepository;
    @Autowired
    private final TeamsRepository teamsRepository;

    public StudioService(GamesRepository gamesRepository, EmployeesRepository employeesRepository, TeamsRepository teamsRepository) {
        this.gamesRepository = gamesRepository;
        this.employeesRepository = employeesRepository;
        this.teamsRepository = teamsRepository;
    }

    public List<Games> findAllGames(){
        return gamesRepository.findAll();
    }
    public List<Employees> findAllEmployees(){
        return employeesRepository.findAll();
    }
    public List<Teams> findAllTeams(){
        return teamsRepository.findAll();
    }


    public Games addGame(Games game){
        Games game2 = new Games();
        game2.setNazwa(game.getNazwa());
        game2.setCena(game.getCena());
        game2.setIlosc(game.getIlosc());
        game2.setStars(game.getStars());
        game2.setOpis(game.getOpis());
        game2.setTeamId(game.getTeamId());
        gamesRepository.save(game2);
        return game2;
    }

    public Employees addEmployee(Employees employee){
        Employees employee2 = new Employees();
        employee2.setImie(employee.getImie());
        employee2.setNazwisko(employee.getNazwisko());
        employee2.setStanowisko(employee.getStanowisko());
        employee2.setEmployeeTeamId(employee.getEmployeeTeamId());
        employeesRepository.save(employee2);
        return employee2;
    }

    public Teams addTeam(Teams team){
        Teams team2 = new Teams();
        team2.setNazwa(team.getNazwa());
        team2.setKoszt(team.getKoszt());
        team2.setLokalizacja(team.getLokalizacja());
        team2.setOcena(team.getOcena());
        team2.setData_zal(team.getData_zal());
        teamsRepository.save(team2);
        return team2;
    }

    public String deleteGame(Long id) {
        Optional<Games> optionalGame = gamesRepository.findById(id);
        if (optionalGame.isPresent()) {
            gamesRepository.deleteById(id);
            return "Game has been removed from the database.";
        } else {
            return "Game not found.";
        }
    }

    public String deleteEmployee(Long id) {
        Optional<Employees> optionalEmployee = employeesRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeesRepository.deleteById(id);
            return "Employee has been removed from the database.";
        } else {
            return "Employee not found";
        }
    }

    public String deleteTeam(Long id) {
        Optional<Teams> optionalTeam = teamsRepository.findById(id);
        if (optionalTeam.isPresent()) {
            teamsRepository.deleteById(id);
            return "Team has been removed from the database.";
        } else {
            return "Team not found.";
        }
    }



    public Games editGame(Games game, Long id){
        Optional<Games> game1 = gamesRepository.findById(id);
        if(game1.isPresent()){
            Games game2 = game1.get();
            game2.setNazwa(game.getNazwa());
            game2.setIlosc(game.getIlosc());
            game2.setStars(game.getStars());
            game2.setCena(game.getCena());
            game2.setOpis(game.getOpis());
            game2.setTeamId(game.getTeamId());
            return gamesRepository.save(game2);
        }else{
            return null;
        }
    }

    public Employees editEmployee(Employees employee, Long id){
        Optional<Employees> employee1 = employeesRepository.findById(id);
        if(employee1.isPresent()){
            Employees employee2 = employee1.get();
            employee2.setImie(employee.getImie());
            employee2.setNazwisko(employee.getNazwisko());
            employee2.setStanowisko(employee.getStanowisko());
            employee2.setEmployeeTeamId(employee.getEmployeeTeamId());
            return employeesRepository.save(employee2);
        }else{
            return null;
        }
    }

    public Teams editTeam(Teams team, Long id){
        Optional<Teams> team1 = teamsRepository.findById(id);
        if(team1.isPresent()){
            Teams team2 = team1.get();
            team2.setNazwa(team.getNazwa());
            team2.setOcena(team.getOcena());
            team2.setKoszt(team.getKoszt());
            team2.setLokalizacja(team.getLokalizacja());
            team2.setData_zal(team.getData_zal());
            return teamsRepository.save(team2);
        }else{
            return null;
        }
    }

}
