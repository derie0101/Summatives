/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.guessinggame.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.guessgaming.daos.GuessingGameExceptions;
import sg.guessinggame.dto.Game;
import sg.guessinggame.dto.Round;
import sg.guessinggame.service.ServiceLayer;

/**
 *
 * @author QUEEN
 */
@RestController
@RequestMapping("/api")
public class GuessingGameController {
     
    ServiceLayer service;

    public GuessingGameController(ServiceLayer service) {
        this.service = service;
    }
    
    @PostMapping("/NewGame")
    public Game newGame() throws GuessingGameExceptions{
        return service.newGame(); 
    }
       
    
    @PostMapping("/UserGuess")
    public Round newUserGuess(int gameId, String userGuess) throws GuessingGameExceptions{
        return service.resultsOfRound(gameId, userGuess);
    }
    
    @GetMapping("/GetAllGames")
    public List<Game> getAllGames() throws GuessingGameExceptions{
        return service.getAllGames();
    }
    
    @GetMapping("/GetGameByID")
    public Game getGameByID(int gameId) throws GuessingGameExceptions{
        return service.getAGameByID(gameId);
    }
    
    @GetMapping("/GetAllRoundsOfAGame")
     public List<Round> getAllRoundsInGame(int gameId) throws GuessingGameExceptions{
         return service.getAllRoundsInGame(gameId);
     }
}
    
     


  

  
      
    
  

