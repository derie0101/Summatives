/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.guessgaming.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sg.guessinggame.dto.Game;

/**
 *
 * @author QUEEN
 */
public class GameTemplateDao implements GameDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Game getAGameByID(int gameId) throws GuessingGameExceptions {
        try {
            final String GET_GAME_BY_ID = "SELECT * FROM Game WHERE id = ?";
            return jdbc.queryForObject(GET_GAME_BY_ID, new GameMapper(), gameId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() throws GuessingGameExceptions {
        final String GET_ALL_GAMES = "SELECT * FROM Game";
        return jdbc.query(GET_ALL_GAMES, new GameMapper());
    }

    @Override
    public Game newGame(Game newGame) throws GuessingGameExceptions {
        final String INSERT_GAME = "INSERT INTO Game(gameRandomizedNumber, statusOfGame) "
                + "VALUES(?,?)";
        jdbc.update(INSERT_GAME,
                newGame.getGameRandomizerNumber(),
                newGame.getStatusofGame());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newGame.setGameID(newId);
        return newGame;
    }

    @Override
    public void deleteGameByID(Integer gameID) throws GuessingGameExceptions {
        final String DELETE_ROUNDS_BY_GAME_ID = "DELETE from rounds where gameID =?";

        jdbc.update(DELETE_ROUNDS_BY_GAME_ID, gameID);

        final String DELETE_GAME_BY_ID = "DELETE FROM GAME WHERE gameID= ?";

        jdbc.update(DELETE_GAME_BY_ID, gameID);
    }

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setGameID(rs.getInt("GameId"));
            game.setGameRandomizerNumber(rs.getString("GameRandomizerNumber"));
            game.setStatusofGame(rs.getInt("StatusofGame"));

            return game;
        }
    }
}
