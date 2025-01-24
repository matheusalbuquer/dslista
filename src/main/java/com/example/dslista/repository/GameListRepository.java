package com.example.dslista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dslista.entities.Game;
import com.example.dslista.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
