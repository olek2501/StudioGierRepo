package com.example.studiogier.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studiogier.entity.Games;
import org.springframework.stereotype.Repository;
//import java.awt.print.Hurtownia;


@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
    // <Optional>

}
