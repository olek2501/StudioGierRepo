package com.example.studiogier.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Teams")
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teamId", nullable = false, updatable = false)
    private Long teamId;
    private String nazwa;
    private String lokalizacja;
    private Integer koszt;
    private Integer ocena;
    @Temporal(TemporalType.DATE)
    private Date data_zal;


    @OneToMany(mappedBy="teams")
    private Set<Games> games;
    @OneToMany(mappedBy="teams")
    private Set<Employees> employees;


    // Gettery i Settery

    public Long getTeamId(){
        // if no work remove "this"
        return this.teamId;
    }
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    public String getNazwa(){
        return this.nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getLokalizacja(){
        return this.lokalizacja;
    }
    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }
    public Integer getKoszt(){
        return this.koszt;
    }
    public void setKoszt(Integer koszt) {
        this.koszt = koszt;
    }
    public Integer getOcena(){
        return this.ocena;
    }
    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }
    public Date getData_zal(){
        return this.data_zal;
    }
    public void setData_zal(Date data_zal){
        this.data_zal = data_zal;
    }



}
