/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.guessinggame.service;

import java.util.List;
import sg.guessgaming.daos.GuessingGameExceptions;
import sg.guessinggame.dto.Game;
import sg.guessinggame.dto.Round;



/**
 *
 * @author QUEEN
 */
public interface ServiceLayer {
    
   Game getAGameByID(int gameId)throws GuessingGameExceptions;

    List<Game> getAllGames() throws GuessingGameExceptions;

    Game newGame() throws GuessingGameExceptions;

    Round getARoundByID(int roundId) throws GuessingGameExceptions;

    List<Round> getAllRoundsInGame(int gameId )throws GuessingGameExceptions;

    Round newRound(Round newRound) throws GuessingGameExceptions;
    
    Round resultsOfRound (int gameId, String userGuess) throws GuessingGameExceptions;
}


