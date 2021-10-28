/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameServiceLayer;

import GuessingGame.GuessingGameDTO.Game;
import GuessingGame.GuessingGameDTO.Round;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import GuessingGame.GuessingGameDAO.GamesnRoundDao;
import GuessingGame.GuessingGameDAO.GuessingGameException;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author QUEEN
 */



@Service
public class ServiceLayerImpl implements ServiceLayer {
    
    @Autowired
    GamesnRoundDao GMDao;

    //public ServiceLayerImpl( GamesnRoundDao GMDao) {
        //this.GMDao = GMDao;
        
    
    

    @Override
    public Game GetAGameByID(int gameId)throws GuessingGameException  {
        return GMDao.GetAGameByID(gameId);
    }

    @Override
    public List<Game> GetAllGames()throws GuessingGameException  {
        return GMDao.GetAllGames();
    }

    @Override
    public Game CreateGame()throws GuessingGameException  {
           Game newGame = new Game();
        Random rGen = new Random();
        int[] randomNumbers = new int[4];
        for (int i = 0; i < randomNumbers.length; i++) {
            boolean valid = false;
            while (valid == false) {
                int a = rGen.nextInt(10) + 1;
                for (int j = 0; j < randomNumbers.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (a > randomNumbers[j] || a < randomNumbers[j]) {
                        valid = true;
                    } else {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    randomNumbers[i] = a;
                }
            }
        }
        newGame.setTargetNumber("" + randomNumbers[0] + randomNumbers[1] + randomNumbers[2] + randomNumbers[3]);
        newGame.setStatusOfGame(1);

        return GMDao.NewGame(newGame);
    }
    

    @Override
    public Round GetARoundByTheID(int roundId)throws GuessingGameException  {
       Round rounds = GMDao.GetARoundByTheID(roundId);
     return rounds;
         
    }

    @Override
    public List<Round> GetAllRoundsInTheGame(int gameId) throws GuessingGameException {
        
       List<Round> Rounds= GMDao.GetAllTheRoundsInAGame(gameId);
        return Rounds;
    }

    @Override
    public Round NewRound(Round newRound) throws GuessingGameException {
        Round rounds = GMDao.newRound(newRound);
        return rounds;
        
    }

    @Override
    public Round FinalResultsOfRound(int gameId, String userGuess)throws GuessingGameException  {
        int partial = 0;
        int exact = 0;
        Game newGame = GMDao.GetAGameByID(gameId);
        String random = newGame.getTargetNumber();
        for (int i = 0; i < random.length(); i++) {
            char c = random.charAt(i);
            char b = userGuess.charAt(i);
            if (c == b) {
                exact = exact + 1;
            } else if (random.indexOf(b) != i && random.indexOf(b) != -1) {
                partial = partial + 1;
            }
        }
        String result = ("e : " + exact + " ; " + "p : " + partial + " ");
        Round newRound = new Round();
        newRound.setGameId(gameId);
        newRound.setUserGuess(userGuess);
        newRound.setFinalResults(result);
        GMDao.newRound(newRound);
        return newRound;
        
        
       
    }
    
}
