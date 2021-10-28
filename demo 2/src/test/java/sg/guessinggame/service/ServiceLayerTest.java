/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.guessinggame.service;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sg.guessgaming.daos.GameDao;
import sg.guessgaming.daos.GuessingGameExceptions;
import sg.guessgaming.daos.RoundDao;
import sg.guessinggame.dto.Game;
import sg.guessinggame.dto.Round;

/**
 *
 * @author QUEEN
 */
public class ServiceLayerTest {
    
//RunWith(SpringRunner.class)
@SpringBootTest

public class ServiceLayerImplTest {

    @Autowired
    RoundDao roundDao;

    @Autowired
    GameDao gameDao;

    @Autowired
    ServiceImpl service;

    public ServiceLayerImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws GuessingGameExceptions {

        List<Game> games = gameDao.getAllGames();
        for (Game game : games) {
            List<Round> rounds = roundDao.getAllRoundsInGame(game.getGameID());
            for (Round round : rounds) {
                roundDao.deleteRoundsByID(round.getRoundId());
            }
            gameDao.deleteGameByID(game.getGameID());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAGameByID method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetAGameByID() {
    }

    /**
     * Test of getAllGames method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetAllGames() {
    }

    /**
     * Test of newGame method, of class ServiceLayerImpl.
     */
    @Test
    public void testNewGame() {
    }

    /**
     * Test of getARoundByID method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetARoundByID() {
    }

    /**
     * Test of getAllRoundsInGame method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetAllRoundsInGame() {
    }

    /**
     * Test of newRound method, of class ServiceLayerImpl.
     */
    @Test
    public void testNewRound() {
    }

    /**
     * Test of resultsOfRound method, of class ServiceLayerImpl.
     */
    @Test
    public void testResultsOfRound() throws GuessingGameExceptions {
        Game game = service.newGame();

        String s = game.getGameRandomizerNumber();

        Round round = new Round();

        round.setGameId(game.getGameID());
        round.setUserGuess(s);
        round.setUserResult("true");
        String date = "2019-07-08T12:27:46";
        LocalDateTime localdatetime = LocalDateTime.parse(date);
        round.setTime(localdatetime);

        service.newRound(round);

        Round fromDao = service.getARoundByID(round.getRoundId());

        s.substring(0, 2);

        fromDao = service.resultsOfRound((game.getGameID()), round.getUserGuess());

        assertEquals("e:3:p:1", fromDao.getUserResult());
        

        Game game2 = service.newGame();

        String s1 = game.getGameRandomizerNumber();

        Round rounds = new Round();

        rounds.setGameId(game2.getGameID());
        rounds.setUserGuess(s);
        rounds.setUserResult("true");
        String dates = "2019-10-08T12:12:39";
        LocalDateTime localdatetimes = LocalDateTime.parse(dates);
        round.setTime(localdatetimes);

       // service.newRound(round);

        Round fromDaos = service.getARoundByID(round.getRoundId());

        s.substring(0, 3);

        fromDaos = service.resultsOfRound((game.getGameID()), round.getUserGuess());

        assertEquals("e:4:p:0", fromDao.getUserResult());

    }
}

}
