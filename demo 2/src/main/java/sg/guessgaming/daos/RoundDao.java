/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.guessgaming.daos;

import java.util.List;
import sg.guessinggame.dto.Round;

/**
 *
 * @author QUEEN
 */
public interface RoundDao {
     Round getARoundByID (int roundId)  throws GuessingGameExceptions;
    
    List<Round> getAllRoundsInGame (int gameId) throws GuessingGameExceptions;
    
    Round newRound (Round newRound) throws GuessingGameExceptions;
    
   public void deleteRoundsByID (Integer roundID) throws GuessingGameExceptions;   
}
