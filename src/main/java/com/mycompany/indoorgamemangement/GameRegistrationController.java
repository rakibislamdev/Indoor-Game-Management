package com.mycompany.indoorgamemangement;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private ChoiceBox<Integer> boardNoField;
    @FXML
    private TextField maxPlayersField;

    @FXML
    private TableView<Game> gamesTable;
    @FXML
    private TableColumn<Game, String> game_name_field;
    @FXML
    private TableColumn<Game, String> game_type_field;
    @FXML
    private TableColumn<Game, Integer> board_no_field;
    @FXML
    private TableColumn<Game, Integer> max_player_field;

    private final ObservableList<Game> gamesList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the TableView columns
        game_name_field.setCellValueFactory(cellData -> cellData.getValue().gameNameProperty());
        game_type_field.setCellValueFactory(cellData -> cellData.getValue().gameTypeProperty());
        board_no_field.setCellValueFactory(cellData -> cellData.getValue().boardNoProperty().asObject());
        max_player_field.setCellValueFactory(cellData -> cellData.getValue().maxPlayersProperty().asObject());

        // Fetch registered board numbers
        Set<Integer> registeredBoardNumbers = fetchRegisteredBoardNumbers();

        // Populate the ChoiceBox with available board numbers excluding registered ones
        for (int i = 1; i <= 5; i++) {
            if (!registeredBoardNumbers.contains(i)) {
                boardNoField.getItems().add(i);
            }
        }

        // Load games data into TableView
        loadGamesData();

        // Add listener for table selection change
        gamesTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Set the selected game's data into the form fields
                nameField.setText(newSelection.getGameName());
                typeField.setText(newSelection.getGameType());
                boardNoField.setValue(newSelection.getBoardNo());
                maxPlayersField.setText(Integer.toString(newSelection.getMaxPlayers()));
            } else {
                // If no row is selected, clear the form fields
                nameField.clear();
                typeField.clear();
                boardNoField.getSelectionModel().clearSelection();
                maxPlayersField.clear();
            }
        });
    }

    private Set<Integer> fetchRegisteredBoardNumbers() {
        Set<Integer> registeredBoardNumbers = new HashSet<>();
        try {
            // Establish a database connection
            Statement statement = DBConnection.getStatement();

            // Fetch registered board numbers
            String selectQuery = "SELECT DISTINCT board_no FROM games";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                registeredBoardNumbers.add(resultSet.getInt("board_no"));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching registered board numbers: " + e.getMessage());
        }
        return registeredBoardNumbers;
    }

    @FXML
    private void registrationHandler(ActionEvent event) {
        try {
            Statement statement = DBConnection.getStatement();

            String gameName = nameField.getText();
            String gameType = typeField.getText();
            int boardNo = boardNoField.getValue();
            int maxPlayers = Integer.parseInt(maxPlayersField.getText());

            String insertQuery = "INSERT INTO games(game, game_type, board_no, max_player, created_at, updated_at) VALUES "
                    + "('" + gameName + "', '" + gameType + "', " + boardNo + ", " + maxPlayers + ", NOW(), NOW())";

            statement.executeUpdate(insertQuery);

            System.out.println("Game Registration successfully!");

            // Reload game data into table after insertion
            loadGamesData();
        } catch (SQLException e) {
            System.err.println("Game Registration Failed: " + e.getMessage());
        } finally {
            // Close the connection
            DBConnection.closeConnection();
        }
    }

    @FXML
    private void updateGame(ActionEvent event) {
        try {
            Statement statement = DBConnection.getStatement();

            // Get the selected game from the TableView
            Game selectedGame = gamesTable.getSelectionModel().getSelectedItem();

            if (selectedGame != null) {
                String gameName = nameField.getText();
                String gameType = typeField.getText();
                int boardNo = boardNoField.getValue();
                int maxPlayers = Integer.parseInt(maxPlayersField.getText());

                // Assuming you have a way to identify the game to update (e.g., using its ID)
                // Here, I'll use a placeholder variable for the game ID
                int gameId = 1; // Placeholder for the game ID, replace it with the actual game ID

                // Construct the SQL UPDATE statement
                String updateQuery = "UPDATE games SET game='" + gameName + "', game_type='" + gameType + "', board_no="
                        + boardNo + ", max_player=" + maxPlayers + " WHERE id=" + gameId;

                // Execute the query
                statement.executeUpdate(updateQuery);

                System.out.println("Game updated successfully!");

                // Reload game data into table after update
                loadGamesData();
            } else {
                System.out.println("No row selected for update.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating game: " + e.getMessage());
        } finally {
            // Close the connection
            DBConnection.closeConnection();
        }
    }

    private void loadGamesData() {
        try {
            // Establish a database connection
            Statement statement = DBConnection.getStatement();

            // Fetch game data from database
            String selectQuery = "SELECT * FROM games";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Clear existing data in gamesList
            gamesList.clear();

            // Iterate over the ResultSet and populate gamesList
            while (resultSet.next()) {
                String gameName = resultSet.getString("game");
                String gameType = resultSet.getString("game_type");
                int boardNo = resultSet.getInt("board_no");
                int maxPlayers = resultSet.getInt("max_player");

                gamesList.add(new Game(gameName, gameType, boardNo, maxPlayers));
            }

            // Set the items in the TableView
            gamesTable.setItems(gamesList);
        } catch (SQLException e) {
            System.err.println("Error loading game data: " + e.getMessage());
        }
    }

    @FXML
    private void backToPrevious(ActionEvent event) throws IOException {
        App.setRoot("dashboard");
    }
}
