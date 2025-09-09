package com.example.todomanager;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.util.ArrayList;

public class ToDoManager extends Application {


    @Override
    public void start(Stage stage) {

        stage.setTitle("To-Do List");

        //Input text
        TextField myTextField = new TextField();
        myTextField.setPromptText("Task: ");
        //Storing tasks
        ArrayList<String> tasks = new ArrayList<>();

        //ListView to display tasks
        ListView<String> displayTasks = new ListView<>();
        displayTasks.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Button to add tasks
        Button addTask = new Button("Add task");
        addTask.setOnAction(e -> {
            String newTask = myTextField.getText();
            if (!newTask.isEmpty()) {
                tasks.add(newTask);
                displayTasks.getItems().add(newTask);
                myTextField.clear();
            }
        });


        //Button to remove tasks
        Button remove = new Button("Remove Selected");
        remove.setOnAction(e -> {
            var selectedTasks = displayTasks.getSelectionModel().getSelectedItems();
            if (!selectedTasks.isEmpty()) {
                tasks.removeAll(new ArrayList<>(selectedTasks));
                displayTasks.getItems().removeAll(selectedTasks);
            }
        });


        //Layout
        VBox box1 = new VBox(10, myTextField , addTask, displayTasks, remove);
        box1.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box1, 500, 300);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }


}