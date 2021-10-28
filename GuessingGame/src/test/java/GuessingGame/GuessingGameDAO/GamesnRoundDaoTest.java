/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameDAO;

import GuessingGame.GuessingGameDTO.Game;
import GuessingGame.GuessingGameDTO.Round;
import GuessingGame.GuessingGameServiceLayer.InvalidGuessException;
import GuessingGame.GuessingGameServiceLayer.InvalidIdException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author QUEEN
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("DaoTest")
public class GamesnRoundDaoTest {
    //   @AutoWired 

    GamesnRoundDao GRDao;

    private String GameQuery = "Select * G.GameId,G.StatusOfGame,G.GameRandomizedNumber"
            + "From Game G ";

    private String RoundQuery = "Select *, R.RoundID, G.GameID, G.GameID, R.UsersGuess , R.UsersResults, R.RoundTime"
            + "From Round R";

    public GamesnRoundDaoTest() {

    }



@BeforeClass public static void setUpClass() {
    }

    @AfterClass public static void tearDownClass() {
    }

    @Before public void setUp() {
        GRDao.DeleteGameByTheID(Integer.SIZE);
        GRDao.DeleteTheRoundsByTheID(Integer.SIZE);
        
    }

    @After public void tearDown() {
    }

    /**
     * Test of GetAGameByID method, of class GamesnRoundDao.
     */
    @Test public void testGoldenPathGetAGameByID()  {
        try {
            Game ToTest = GRDao.GetAGameByID(1234);
            Game Validate = GRDao.GetAGameByID(ToTest.getGameId());
            assertEquals(453, Validate.getGameId());
        } catch (GuessingGameException ex) {
            fail();
        }
    }
    

    @Test public void GetAGamebyInvalidId () {
        try {
            Game ToTest = GRDao.GetAGameByID(1234);
            Game Validate = GRDao.GetAGameByID(ToTest.getGameId());
        } catch (GuessingGameException ex) {
           fail();
        }
       
}

    /**
     * Test of GetAllGames method, of class GamesnRoundDao.
     */
    @Test public void testGoldenPathGetAllGames() {
        try {
            Game game1 = new Game();
            
            game1.setTargetNumber("2");
            game1.setGameId(1);
            game1.setStatusOfGame(3);
            
            Game game2 = new Game();
            
            game2.setTargetNumber("2");
            game2.setGameId(2);
            game2.setStatusOfGame(4);
            
            assertEquals(2, GRDao.GetAllGames().size());
        } catch (GuessingGameException ex) {
           fail();
        }
               
        
        
    }

    /**
     * Test of NewGame method, of class GamesnRoundDao.
     */
    @Test public void testGoldenPathNewGame() {
        try {
            Game game = new Game();
            game.setGameId(1);
            game.setTargetNumber("2");
            game.setStatusOfGame(3);
            
            Game AddGame = GRDao.GetAGameByID(game.getGameId());
        } catch (GuessingGameException ex) {
           fail();
        }
           
    }

        /**
         * Test of DeleteGameByTheID method, of class GamesnRoundDao.
         */
        @Test public void testGoldenPathDeleteGameByTheID() {
        try {
            Game game = new Game();
            game.setGameId(1);
            game.setTargetNumber("2");
            game.setStatusOfGame(3);
            
            Game DeleteGame = GRDao.GetAGameByID(game.getGameId());
        } catch (GuessingGameException ex) {
           fail();
        }
            
   
    
        
     
            
        
}

    /**
     * Test of GetARoundByTheID method, of class GamesnRoundDao.
     */
    @Test public void testGetARoundByTheID()  {
        try {
            Round Totest = new Round();
            Round Validate = GRDao.GetARoundByTheID(1);
            assertEquals(1, GRDao.GetARoundByTheID(
           
        } catch (GuessingGameException ex) {
           fail();
        }
          
          
                  
        
        }

        /**
         * Test of GetAllTheRoundsInAGame method, of class GamesnRoundDao.
         */
        @Test
        public void testGetAllTheRoundsInAGame() {
        }

        /**
         * Test of newRound method, of class GamesnRoundDao.
         */
        @Test
        public void testNewRound() throws Exception {
        }

        /**
         * Test of DeleteTheRoundsByTheID method, of class GamesnRoundDao.
         */
        @Test
        public void testDeleteTheRoundsByTheID() {
    }

}

    
       
