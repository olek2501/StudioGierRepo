package com.example.studiogier.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeId", nullable = false, updatable = false)
    private Long employeeId;
    private String imie;
    private String nazwisko;
    private String stanowisko;

    @ManyToOne
    @JoinColumn(name="employeeTeamId", nullable = false)
    private Teams teams;


    // Getters and Setters:

    public Long getEmployeeId(){
        // if no work remove "this"
        return this.employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public String getImie(){
        return this.imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko(){
        return this.nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public Long getEmployeeTeamId(){
        return teams != null ? teams.getTeamId() : null;
    }
    public void setEmployeeTeamId(Long teamId) {
        if (teamId == null) {
            this.teams = null;
        } else {
            this.teams = new Teams();
            this.teams.setTeamId(teamId);
        }
    }
    public String getStanowisko(){
        return this.stanowisko;
    }
    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }
}
