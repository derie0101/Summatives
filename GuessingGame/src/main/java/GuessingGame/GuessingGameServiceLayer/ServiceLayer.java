/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameServiceLayer;

import GuessingGame.GuessingGameDAO.GuessingGameException;
import GuessingGame.GuessingGameDTO.Game;
import GuessingGame.GuessingGameDTO.Round;
import java.util.List;

/**
 *
 * @author Queen
 */
public interface ServiceLayer {

    Game GetAGameByID(int gameId)throws GuessingGameException ;

    List<Game> GetAllGames()throws GuessingGameException ;

    Game CreateGame() throws GuessingGameException ;

    Round GetARoundByTheID(int roundId)throws GuessingGameException ;

    List<Round> GetAllRoundsInTheGame(int gameId)throws GuessingGameException ;

    Round NewRound(Round newRound)throws GuessingGameException ;
    
    Round FinalResultsOfRound (int gameId, String userGuess)throws GuessingGameException ;
    
}
