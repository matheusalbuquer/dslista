package com.example.dslista.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dslista.dto.GameDTO;
import com.example.dslista.dto.GameListDTO;
import com.example.dslista.dto.GameMinDTO;
import com.example.dslista.entities.Game;
import com.example.dslista.entities.GameList;
import com.example.dslista.repository.GameListRepository;
import com.example.dslista.repository.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	

	@Transactional (readOnly = true)
	public List<GameListDTO> findAll (){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
