package com.mycompany.indoorgamemangement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {
    private final StringProperty gameName;
    private final StringProperty gameType;
    private final IntegerProperty boardNo;
    private final IntegerProperty maxPlayers;

    public Game(String gameName, String gameType, int boardNo, int maxPlayers) {
        this.gameName = new SimpleStringProperty(gameName);
        this.gameType = new SimpleStringProperty(gameType);
        this.boardNo = new SimpleIntegerProperty(boardNo);
        this.maxPlayers = new SimpleIntegerProperty(maxPlayers);
    }

    public StringProperty gameNameProperty() {
        return gameName;
    }

    public StringProperty gameTypeProperty() {
        return gameType;
    }

    public IntegerProperty boardNoProperty() {
        return boardNo;
    }

    public IntegerProperty maxPlayersProperty() {
        return maxPlayers;
    }

    public String getGameName() {
        return gameName.get();
    }

    public void setGameName(String gameName) {
        this.gameName.set(gameName);
    }

    public String getGameType() {
        return gameType.get();
    }

    public void setGameType(String gameType) {
        this.gameType.set(gameType);
    }

    public int getBoardNo() {
        return boardNo.get();
    }

    public void setBoardNo(int boardNo) {
        this.boardNo.set(boardNo);
    }

    public int getMaxPlayers() {
        return maxPlayers.get();
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers.set(maxPlayers);
    }
}
