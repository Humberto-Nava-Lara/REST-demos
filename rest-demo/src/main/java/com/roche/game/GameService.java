package com.roche.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class GameService {

	private List<Game> games = new ArrayList<>(Arrays.asList(
			new Game("CCD", "Castlevania: CUrse of darkness", "Action-adventure game developed by Konami for the PlayStation 2 and Xbox"), 
			new Game("MVC2", "Marvel vs Capcom 2", "Crossover fighting game developed and published by Capcom")));
	
	public List<Game> getGames() {
		return games;
	}
	
	public Game getGame(String id) {
		return games.stream().filter(g -> g.getId().equals(id)).findFirst().get();
	}
	
	public void addGame(Game game) {
		games.add(game);
	}
	
	public void updateGame(String id, Game game) {
//		for(int i = 0; i < games.size(); i++) {
//			Game g = games.get(i);
//			if(g.getId().equals(id)) {
//				games.set(i, game);
//			}
//		}
		games = games.stream().map(g -> g.getId().equals(game.getId()) ? game : g).collect(Collectors.toList());
	}
	
	public void deleteGame(String id) {
		games.removeIf(g -> g.getId().equals(id));
	}
	
}
