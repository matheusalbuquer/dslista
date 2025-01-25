package com.example.dslista.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dslista.dto.GameDTO;
import com.example.dslista.dto.GameListDTO;
import com.example.dslista.dto.GameMinDTO;
import com.example.dslista.dto.ReplacementDTO;
import com.example.dslista.entities.Game;
import com.example.dslista.services.GameListService;
import com.example.dslista.services.GameService;

@RestController
@RequestMapping (value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListservice;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping 
	public List<GameListDTO> findAll () {
		List<GameListDTO> result = gameListservice.findAll();
		return result;
	}
	
	@GetMapping (value = "/{listId}/games")
	public List<GameMinDTO> findByList (@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findAllByList(listId);
		return result;
	}
	
	@PostMapping (value = "/{listId}/replacement")
	public void move (@PathVariable Long listId, @RequestBody ReplacementDTO body ) {
		gameListservice.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}
