/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameDTO;

import java.time.LocalDateTime;
/**
 *
 * @author QUEEN
 */





public class Round {
    int RoundId;
    int GameId;
    String UsersGuess;
    LocalDateTime time = LocalDateTime.now();
    String FinalResults;

    public int getRoundId() {
        return RoundId;
    }

    public void setRoundId(int roundId) {
        this.RoundId = roundId;
    }

    public int getGameId() {
        return GameId;
    }

    public void setGameId(int gameId) {
        this.GameId = gameId;
    }

    public String getUserGuess() {
        return UsersGuess;
    }

    public void setUserGuess(String userGuess) {
        this.UsersGuess = userGuess;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getUserResult() {
        return FinalResults;
    }

    public void setFinalResults(String FinalResult) {
        this.FinalResults = FinalResults;
    }
    
    
}
