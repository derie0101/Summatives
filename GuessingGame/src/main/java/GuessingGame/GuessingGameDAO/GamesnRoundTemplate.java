/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameDAO;

import GuessingGame.GuessingGameDAO.GamesnRoundTemplate.GameMapper.RoundMapper;
import GuessingGame.GuessingGameDTO.Game;
import GuessingGame.GuessingGameDTO.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author QUEEN
 */
@Repository
public class GamesnRoundTemplate implements GamesnRoundDao {

    @Autowired
    JdbcTemplate JDBC;

    @Override
    public Game GetAGameByID(int GameId)throws GuessingGameException {
        try {
            final String GET_GAME_BY_ID = "SELECT * FROM Game WHERE Id = ?";
            return JDBC.queryForObject(GET_GAME_BY_ID, new GameMapper(), GameId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Game> GetAllGames() throws GuessingGameException{
        final String GET_ALL_GAMES = "SELECT * FROM Game";
        return JDBC.query(GET_ALL_GAMES, new GameMapper());
    }

    @Override
    public Game NewGame(Game newGame) throws GuessingGameException{
        final String INSERT_GAME = "INSERT INTO Game(TargetNumber, FinalResults) "
                + "VALUES(?,?)";
        JDBC.update(INSERT_GAME,
                newGame.getTargetNumber(),
                newGame.getStatusOfGame());

        int newId = JDBC.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newGame.setGameId(newId);
        return newGame;
    }

    @Override
    public void DeleteGameByTheID(Integer gameID) {
        final String DELETE_ROUNDS_BY_GAME_ID = "DELETE from rounds where gameID =?";

        JDBC.update(DELETE_ROUNDS_BY_GAME_ID, gameID);

        final String DELETE_GAME_BY_ID = "DELETE FROM GAME WHERE gameId= ?";

        JDBC.update(DELETE_GAME_BY_ID, gameID);
    }

    @Override
    public Round GetARoundByTheID(int roundId) throws GuessingGameException{

        try {
            final String GET_ROUND_BY_ID = "SELECT * FROM Round WHERE id = ?";
            return JDBC.queryForObject(GET_ROUND_BY_ID, new RoundMapper(), roundId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Round> GetAllTheRoundsInAGame(int gameId) throws GuessingGameException{
        final String GET_ALL_ROUNDS = "SELECT * FROM Round";
        return JDBC.query(GET_ALL_ROUNDS, new RoundMapper());
    }

    @Override
    public Round newRound(Round newRound)throws GuessingGameException {
        final String INSERT_ROUND = "INSERT INTO Round(GameID, UsersGuess, RoundTime, FinalResults ) "
                + "VALUES(?,?,?,?)";
        JDBC.update(INSERT_ROUND,
                newRound.getGameId(),
                newRound.getUserGuess(),
                newRound.getTime(),
                newRound.getUserResult());

        int newId = JDBC.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newRound.setRoundId(newId);
        return newRound;
    }

    @Override
    public void DeleteTheRoundsByTheID(Integer roundID) {

        final String DELETE_ROUNDS_BY_ID = "DELETE FROM rounds WHERE RoundId = ?";

        JDBC.update(DELETE_ROUNDS_BY_ID, roundID);
    }

   

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setGameId(rs.getInt("GameId"));
            game.setTargetNumber(rs.getString("TargetNumber"));
            game.setStatusOfGame(rs.getInt("TargetGame"));

            return game;
        }

        public static final class RoundMapper implements RowMapper<Round> {

            @Override
            public Round mapRow(ResultSet rs, int index) throws SQLException {
                Round round = new Round();
                round.setRoundId(rs.getInt("RoundId"));
                round.setGameId(rs.getInt("GameID"));
                round.setUserGuess(rs.getString("UsersGuess"));
                round.setTime(rs.getTimestamp("RoundTime").toLocalDateTime());
                round.setFinalResults(rs.getString("FinalResults"));

                return round;
            }

    

                }
            }
        }
    

