package com.example.dslista.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dslista.dto.GameDTO;
import com.example.dslista.dto.GameMinDTO;
import com.example.dslista.entities.Game;
import com.example.dslista.projections.GameMinProjection;
import com.example.dslista.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id){
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	
	public List<GameMinDTO> findAll (){
		List <Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	public List<GameMinDTO> findAllByList(Long listId){
		List <GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}	
}
