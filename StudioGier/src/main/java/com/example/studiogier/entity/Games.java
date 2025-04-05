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
@Table(name = "Games")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gameId", nullable = false, updatable = false)
    private Long id;
    private String nazwa;
    private Integer cena;
    private Integer ilosc;
    private Integer stars;
//    private Long teamId;
    private String opis;


    @ManyToOne
    @JoinColumn(name="teamId", nullable = false)
    private Teams teams;



//    @ManyToMany(cascade = CascadeType.ALL)
//    Set<Samochod> zamowienia = new HashSet<>();


    public Long getGameById() {
        return this.id;
    }
    public void setGameId(Long id) {
        this.id = id;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public Integer getCena() {
        return cena;
    }
    public void setCena(Integer cena) {
        this.cena = cena;
    }
    public Integer getIlosc(){
        return ilosc;
    }
    public void setIlosc(Integer ilosc){
        this.ilosc = ilosc;
    }
    public Integer getStars(){
        return stars;
    }
    public void setStars(Integer stars){
        this.stars = stars;
    }
    public Long getTeamId(){
        return teams != null ? teams.getTeamId() : null;
    }
    public void setTeamId(Long teamId) {
        if (teamId == null) {
            this.teams = null;
        } else {
            this.teams = new Teams();
            this.teams.setTeamId(teamId);
        }
    }

    public String getOpis(){
        return opis;
    }

    public void setOpis(String opis){
        this.opis = opis;
    }
}
