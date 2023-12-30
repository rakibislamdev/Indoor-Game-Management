/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.indoorgamemangement;

/**
 *
 * @author Rakib
 */
public class Game {
    private String gameName;
    private String gameType;
    private int boardNo;
    private int maxPlayers;

    public Game(String gameName, String gameType, int boardNo, int maxPlayers) {
        this.gameName = gameName;
        this.gameType = gameType;
        this.boardNo = boardNo;
        this.maxPlayers = maxPlayers;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @Override
    public String toString() {
        return "Game{" + "gameName=" + gameName + ", gameType=" + gameType + ", boardNo=" + boardNo + ", maxPlayers=" + maxPlayers + '}';
    }
    
    
    
}
