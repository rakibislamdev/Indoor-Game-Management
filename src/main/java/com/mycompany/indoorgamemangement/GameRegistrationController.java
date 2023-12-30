/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.indoorgamemangement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rakib
 */
public class GameRegistrationController implements Initializable {

    @FXML
    private Insets x1;
    @FXML
    private Insets x2;
    @FXML
    private TextField nameField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField boardNoField;
    @FXML
    private TextField maxPlayersField;
    @FXML
    private TextField durationField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void registrationHandler(ActionEvent event) {
        String gameName = nameField.getText();
        String gameType = typeField.getText();
        int boardNo = Integer.parseInt(boardNoField.getText());
        int maxPlayers = Integer.parseInt(maxPlayersField.getText());

        System.out.println("Game Name: " + gameName);
        System.out.println("Game Type: " + gameType);
        System.out.println("Board Number: " + boardNo);
        System.out.println("Max Players: " + maxPlayers);
    }

}
