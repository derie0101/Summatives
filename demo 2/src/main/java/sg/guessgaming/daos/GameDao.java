/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.guessgaming.daos;

import java.util.List;
import sg.guessinggame.dto.Game;



/**
 *
 * @author QUEEN
 */
public interface GameDao {
     
    Game getAGameByID (int gameId) throws GuessingGameExceptions;
    
    List<Game> getAllGames()  throws GuessingGameExceptions;
    
    Game newGame (Game newGame)  throws GuessingGameExceptions;
    
    public void deleteGameByID (Integer gameID)  throws GuessingGameExceptions;
    
}
    

