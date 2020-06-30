package com.roche.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	@Autowired
	GameService gameService;

	@RequestMapping("/games")
	public List<Game> getGames() {
		return gameService.getGames();
	}
	
	@RequestMapping("/games/{id}")
	public Game getGame(@PathVariable String id) {
		return gameService.getGame(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/games")
	public void addGame(@RequestBody Game game){
		gameService.addGame(game);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/games/{id}")
	public void updateGame(@RequestBody Game game, @PathVariable String id) {
		gameService.updateGame(id, game);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/games/{id}")
	public void deleteGame(@PathVariable String id) {
		gameService.deleteGame(id);
	}
}
