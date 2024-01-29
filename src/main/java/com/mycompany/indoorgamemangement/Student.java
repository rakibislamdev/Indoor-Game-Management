package com.mycompany.indoorgamemangement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty name;
    private final StringProperty studentId;
    private final StringProperty batch;
    private final StringProperty email;
    private final StringProperty department;
    private final StringProperty phone;

    public Student() {
        this(null, null, null, null, null, null);
    }

    public Student(String name, String studentId, String batch, String email, String department, String phone) {
        this.name = new SimpleStringProperty(name);
        this.studentId = new SimpleStringProperty(studentId);
        this.batch = new SimpleStringProperty(batch);
        this.email = new SimpleStringProperty(email);
        this.department = new SimpleStringProperty(department);
        this.phone = new SimpleStringProperty(phone);
    }

    // Getters and setters for JavaFX properties
    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty studentIdProperty() {
        return studentId;
    }

    public StringProperty batchProperty() {
        return batch;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    // Getters and setters for regular attributes
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getStudentId() {
        return studentId.get();
    }

    public void setStudentId(String studentId) {
        this.studentId.set(studentId);
    }

    public String getBatch() {
        return batch.get();
    }

    public void setBatch(String batch) {
        this.batch.set(batch);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }
}
