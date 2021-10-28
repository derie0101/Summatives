/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameController;

import GuessingGame.GuessingGameDAO.GuessingGameException;
import GuessingGame.GuessingGameDTO.Game;
import GuessingGame.GuessingGameDTO.Round;
import GuessingGame.GuessingGameServiceLayer.ServiceLayer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author QUEEN
 */


@RestController
@RequestMapping("/api")
public class GuessingGameController {
    
    ServiceLayer service;

    @Autowired
    public GuessingGameController(ServiceLayer service) {
        this.service = service;
    }
    
    @PostMapping("/CreateGame")
    public Game CreateGame() throws GuessingGameException{
        return service.CreateGame();
    }
    
    @PostMapping("/UserGuess")
    public Round newUserGuess(int gameId, String userGuess) throws GuessingGameException{
        return service.FinalResultsOfRound(gameId, userGuess);
    }
    
    @GetMapping("/GetAllGames")
    public List<Game> GetAllGames() throws GuessingGameException{
        return service.GetAllGames();
    }
    
    @GetMapping("/GetGameByTheID")
    public Game getGameByID(int gameId) throws GuessingGameException{
        return service.GetAGameByID(gameId);
    }
    
    @GetMapping("/GetAllRoundsOfTheGame")
     public List<Round> GetAllRoundsInTheGame(int gameId) throws GuessingGameException{
         return service.GetAllRoundsInTheGame(gameId);
     }
}
