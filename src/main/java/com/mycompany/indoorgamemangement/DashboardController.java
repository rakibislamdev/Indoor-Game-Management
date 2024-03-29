/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.indoorgamemangement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Rakib
 */
public class DashboardController implements Initializable {

    @FXML
    private Button stuRegistration;
    @FXML
    private Button gameRegistration;
    @FXML
    private Button slotBooking;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToStudentRegistration(ActionEvent event) throws IOException {
        App.setRoot("studentRegistration");
    }

    @FXML
    private void switchToGameRegistration(ActionEvent event) throws IOException {
        App.setRoot("gameRegistration");
    }

    @FXML
    private void switchToSlotBooking(ActionEvent event) throws IOException {
        App.setRoot("slotBooking");
    }
    
}
