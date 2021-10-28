/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameServiceLayer;

import GuessingGame.GuessingGameDAO.GamesnRoundDao;
import GuessingGame.GuessingGameDAO.GuessingGameException;
import GuessingGame.GuessingGameDTO.Game;
import GuessingGame.GuessingGameDTO.Round;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Queen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerImplTest {

    GamesnRoundDao GMDao;
    @Autowired
    ServiceLayerImpl service;

    public ServiceLayerImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws GuessingGameException {

        List<Game> games = GMDao.GetAllGames();
        for (Game game : games) {
            List<Round> rounds = GMDao.GetAllTheRoundsInAGame(game.getGameId());
            for (Round round : rounds) {
                GMDao.DeleteTheRoundsByTheID(round.getRoundId());
            }
            GMDao.DeleteGameByTheID(game.getGameId());
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
    public void testResultsOfRound() throws GuessingGameException {
        Game game = service.CreateGame();

        String s = game.getGameRandomizedNumber();

        Round round = new Round();

        round.setGameId(game.getGameId());
        round.setUserGuess(s);
        round.setUserResult("true");
        String date = "2019-07-08T12:27:46";
        LocalDateTime localdatetime = LocalDateTime.parse(date);
        round.setTime(localdatetime);

        service.NewRound(round);

        Round GMDao = service.GetARoundByTheID(round.getRoundId());

        s.substring(0, 2);

        GMDao = service.FinalResultsOfRound((game.getGameId()), round.getUserGuess());

        assertEquals("e:3:p:1", GMDao.getUserResult());

        Game game2 = service.CreateGame();

        String s1 = game.getGameRandomizedNumber();

        Round rounds = new Round();

        rounds.setGameId(game2.getGameId());
        rounds.setUserGuess(s);
        rounds.setUserResult("true");
        String dates = "2019-10-08T12:12:39";
        LocalDateTime localdatetimes = LocalDateTime.parse(dates);
        round.setTime(localdatetimes);

        service.NewRound(round);

         GMDao = service.GetARoundByTheID(round.getRoundId());

        s.substring(0, 3);

        GMDao = service.FinalResultsOfRound((game.getGameId()), round.getUserGuess());

        assertEquals("e:4:p:0", GMDao.getUserResult());

    }
}
