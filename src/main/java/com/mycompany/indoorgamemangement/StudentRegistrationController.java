package com.mycompany.indoorgamemangement;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class StudentRegistrationController implements Initializable {

    @FXML
    private Button stuRegBack;
    @FXML
    private TextField name;
    @FXML
    private Insets x1;
    @FXML
    private TextField student_id;
    @FXML
    private TextField batch;
    @FXML
    private TextField email;
    @FXML
    private TextField deperment;
    @FXML
    private TextField phone;
    @FXML
    private Insets x2;
    @FXML
    private Button studentRegistration;
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> nameField;
    @FXML
    private TableColumn<Student, String> emailField;
    @FXML
    private TableColumn<Student, String> batchField;
    @FXML
    private TableColumn<Student, String> depertmentField;
    @FXML
    private TableColumn<Student, String> actionField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize table columns
        nameField.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        emailField.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        batchField.setCellValueFactory(cellData -> cellData.getValue().batchProperty());
        depertmentField.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());

        // Load student data into table
        loadStudentData();
    }

    @FXML
    private void backToPrevious(ActionEvent event) throws IOException {
        App.setRoot("dashboard");
    }

    @FXML
    private void studentRegistration(ActionEvent event) {
        try {
            // Establish a database connection
            Statement statement = DBConnection.getStatement();

            // Get values from the UI
            String studentName = name.getText();
            String studentId = student_id.getText();
            String studentBatch = batch.getText();
            String studentEmail = email.getText();
            String studentDepartment = deperment.getText();
            String studentPhone = phone.getText();

            // Execute SQL INSERT statement
            String insertQuery = "INSERT INTO students (name, student_id, batch, email, depertment, phone, created_at, updated_at) "
                    + "VALUES ('" + studentName + "', '" + studentId + "', '" + studentBatch + "', '" + studentEmail + "', '"
                    + studentDepartment + "', '" + studentPhone + "', NOW(), NOW())";

            // Execute the query
            statement.executeUpdate(insertQuery);

            System.out.println("Student data inserted successfully!");

            // Reload student data into table after insertion
            loadStudentData();
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        } finally {
            // Close the connection
            DBConnection.closeConnection();
        }
    }
    
    private void loadStudentData() {
        try {
            // Establish a database connection
            Statement statement = DBConnection.getStatement();

            // Fetch student data from database
            String selectQuery = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Clear existing data
            studentTable.getItems().clear();

            // Populate table with fetched data
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getString("name"),
                        resultSet.getString("student_id"),
                        resultSet.getString("batch"),
                        resultSet.getString("email"),
                        resultSet.getString("depertment"),
                        resultSet.getString("phone")
                );
                studentTable.getItems().add(student);
            }
        } catch (SQLException e) {
            System.err.println("Error loading student data: " + e.getMessage());
        }
    }
}
