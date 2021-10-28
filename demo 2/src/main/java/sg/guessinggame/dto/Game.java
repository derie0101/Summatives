/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.guessinggame.dto;

/**
 *
 * @author QUEEN
 */
public class Game {

    int gameId;
    String gameRandomizerNumber;
    int StatusofGame;

    public int getGameID() {
        return gameId;
    }

    public void setGameID(int gameId) {
        this.gameId = gameId;
    }

    public String getGameRandomizerNumber() {
        return gameRandomizerNumber;
    }

    public void setGameRandomizerNumber(String gameRandomizerNumber) {
        this.gameRandomizerNumber = gameRandomizerNumber;
    }

    public int getStatusofGame() {
        return StatusofGame;
    }

    public void setStatusofGame(int StatusofGame) {
        this.StatusofGame = StatusofGame;
    }

}
