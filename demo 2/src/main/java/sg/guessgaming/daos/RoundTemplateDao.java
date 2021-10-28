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
import org.springframework.stereotype.Repository;
import sg.guessinggame.dto.Round;

/**
 *
 * @author QUEEN
 */
@Repository
public class RoundTemplateDao implements RoundDao {
@Autowired
   JdbcTemplate jdbc;
     
    @Override
    public Round getARoundByID(int roundId) throws GuessingGameExceptions{
      try {
            final String GET_A_ROUND_BY_ID = "SELECT * FROM roundObject WHERE id = ?";
            return jdbc.queryForObject(GET_A_ROUND_BY_ID, new RoundObjectMapper());
        } catch(DataAccessException ex) {
            return null;
        }    }

    @Override
    public List<Round> getAllRoundsInGame(int gameId) throws GuessingGameExceptions{
 final String GET_ALL_ROUNDS = "SELECT * FROM roundObject";
        return jdbc.query(GET_ALL_ROUNDS, new RoundObjectMapper());    }

    @Override
    public Round newRound(Round newRound) throws GuessingGameExceptions{
  final String INSERT_ROUND = "INSERT INTO roundObject(GameID, userGuess, roundTime, userResult ) " +
                "VALUES(?,?,?,?)";
        jdbc.update(INSERT_ROUND,
                newRound.getGameId(),
                newRound.getUserGuess(),
                newRound.getTime(),
                newRound.getUserResult());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newRound.setRoundId(newId);
        return newRound;    }

    @Override
    public void deleteRoundsByID(Integer roundID) throws GuessingGameExceptions{

        final String DELETE_ROUNDS_BY_ID = "DELETE FROM rounds WHERE roundId = ?";

        jdbc.update(DELETE_ROUNDS_BY_ID, roundID);
    }    
    
  

    
     public static final class RoundObjectMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setRoundId(rs.getInt("roundId"));
            round.setGameId(rs.getInt("GameID"));
            round.setUserGuess(rs.getString("userGuess"));
            round.setTime(rs.getTimestamp("roundTime").toLocalDateTime());
            round.setUserResult(rs.getString("userResult"));
            
            return round;
        }
    }
    
}
