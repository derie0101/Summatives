/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.guessinggame.service;

import java.util.List;
import java.util.Random;
import sg.guessgaming.daos.GameDao;
import sg.guessgaming.daos.GuessingGameExceptions;
import sg.guessgaming.daos.RoundDao;
import sg.guessinggame.dto.Game;
import sg.guessinggame.dto.Round;

/**
 *
 * @author QUEEN
 */
public class ServiceImpl implements ServiceLayer {
    GameDao gODao;
    RoundDao rODao;

    public ServiceImpl(GameDao gODao, RoundDao rODao) {
        this.gODao = gODao;
        this.rODao = rODao;
    }
 @Override
    public Game getAGameByID(int gameId)  throws GuessingGameExceptions{
        return gODao.getAGameByID(gameId);
    }

    @Override
    public List<Game> getAllGames() throws GuessingGameExceptions{
        return gODao.getAllGames();
    }

    @Override
    public Game newGame() throws GuessingGameExceptions{
          
        Game newGame = new Game();
        Random rGen = new Random();
        int[] randomNumbers = new int[4];
        for (int i = 0; i < randomNumbers.length; i++) {
            boolean valid = false;
            while (valid == false) {
                int a = rGen.nextInt(8) + 1;
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
        newGame.setGameRandomizerNumber("" + randomNumbers[0] + randomNumbers[1] + randomNumbers[2] + randomNumbers[3]);
        newGame.setStatusofGame(1);

        return gODao.newGame(newGame);
    }
    

    @Override
    public Round getARoundByID(int roundId) throws GuessingGameExceptions{
       return rODao.getARoundByID(roundId);
       
    }

    @Override
    public List<Round> getAllRoundsInGame(int gameId) throws GuessingGameExceptions{
        return rODao.getAllRoundsInGame(gameId);
    }

    @Override
    public Round newRound(Round newRound) throws GuessingGameExceptions{
        return rODao.newRound(newRound);
    }

    @Override
    public Round resultsOfRound(int gameId, String userGuess)  throws GuessingGameExceptions {
        int partial = 0;
        int exact = 0;
        Game newGame = gODao.getAGameByID(gameId);
        String random = newGame.getGameRandomizerNumber();
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
        newRound.setUserResult(result);
        return rODao.newRound(newRound);
    }
 
    }
 
    

   

    



