package com.example.studiogier.controller;

import com.example.studiogier.entity.Employees;
import com.example.studiogier.entity.Games;
import com.example.studiogier.entity.Teams;
import com.example.studiogier.service.StudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studiogier")
public class StudioController {

    private final StudioService studioService;

    public StudioController(StudioService studioService){
        this.studioService = studioService;
    }

    @GetMapping("/allGames")
    public ResponseEntity<List<Games>> getAllGames(){
        List<Games> games = studioService.findAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employees>> getAllEmployees(){
        List<Employees> employees = studioService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/allTeams")
    public ResponseEntity<List<Teams>> getAllTeams(){
        List<Teams> teams = studioService.findAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping("/insertGame")
    public Games insertBook(@RequestBody Games book){
        return studioService.addGame(book);
    }

    @PostMapping("/insertEmployee")
    public Employees insertEmployee(@RequestBody Employees employee){
        return studioService.addEmployee(employee);
    }

    @PostMapping("/insertTeam")
    public Teams insertTeam(@RequestBody Teams team){
        return studioService.addTeam(team);
    }


    @DeleteMapping("/removeGame{id}")
    public String removeGame(@PathVariable Long id){
        studioService.deleteGame(id);
        return null;
    }

    @DeleteMapping("/removeEmployee{id}")
    public String removeEmployee(@PathVariable Long id){
        studioService.deleteEmployee(id);
        return null;
    }

    @DeleteMapping("/removeTeam{id}")
    public String removeTeam(@PathVariable Long id){
        studioService.deleteTeam(id);
        return null;
    }

    @PutMapping("/editGame{id}")
    public Games changeGame(@RequestBody Games game, @PathVariable Long id){
        return studioService.editGame(game, id);
    }

    @PutMapping("/editEmployee{id}")
    public Employees changeEmployee(@RequestBody Employees employee, @PathVariable Long id){
        return studioService.editEmployee(employee, id);
    }

    @PutMapping("/editTeam{id}")
    public Teams changeTeam(@RequestBody Teams team, @PathVariable Long id){
        return studioService.editTeam(team, id);
    }

}
