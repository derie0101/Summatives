/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameDAO;

import GuessingGame.GuessingGameDTO.Game;
import GuessingGame.GuessingGameDTO.Round;
import java.util.List;

/**
 *
 * @author QUEEN
 */


public interface GamesnRoundDao {
    
    Game GetAGameByID (int gameId) throws GuessingGameException;
    
    List<Game> GetAllGames()throws GuessingGameException;
    
    Game NewGame (Game newGame)throws GuessingGameException;
    
    public void DeleteGameByTheID (Integer gameID);
   
     Round GetARoundByTheID(int roundId)throws GuessingGameException;

    List<Round> GetAllTheRoundsInAGame(int gameId)throws GuessingGameException;

    Round newRound(Round newRound)throws GuessingGameException;

    public void DeleteTheRoundsByTheID(Integer roundID);
            
    
}
