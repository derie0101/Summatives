/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameDTO;

/**
 *
 * @author QUEEN
 * 
 */
public class Game {
    int GameId;
    String TargetNumber;
    int StatusOfGame;

    public int getGameId() {
        return GameId;
    }

    public void setGameId(int gameId) {
        this.GameId = GameId;
    }

    public String getTargetNumber() {
        return TargetNumber;
    }

    public void setTargetNumber(String GameRandomizedNumber) {
        this.TargetNumber = GameRandomizedNumber;
    }

    public int getStatusOfGame() {
        return StatusOfGame;
    }

    public void setStatusOfGame(int StatusOfGame) {
        this.StatusOfGame = StatusOfGame;
    }
    
    
}
