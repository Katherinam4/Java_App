package com.example.java_final_prep;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public void start(Stage stage) {

        Button button1 = new Button("Submit");
        button1.setTranslateX(60);
        button1.setTranslateY(320);

        Button button2 = new Button("Show chart");
        button2.setTranslateX(60);
        button2.setTranslateY(270);

        Text text=new Text();
        text.setTranslateX(40);
        text.setTranslateY(50);
        text.setText("Name");

        TextField textField1=new TextField();
        textField1.setTranslateX(40);
        textField1.setTranslateY(60);

        Text text2=new Text();
        text2.setTranslateX(40);
        text2.setTranslateY(110);
        text2.setText("Subject");

        TextField textField2=new TextField();
        textField2.setTranslateX(40);
        textField2.setTranslateY(120);

        Text text3=new Text();
        text3.setTranslateX(40);
        text3.setTranslateY(170);
        text3.setText("Mark");

        TextField textField3=new TextField();
        textField3.setTranslateX(40);
        textField3.setTranslateY(180);

        Group root = new Group();

        button1.setOnAction(actionEvent -> {
            String  name = textField1.getText();
            String subject = textField2.getText();
            int mark = Integer.parseInt(textField3.getText());
            try {
                StudentUtils.insertStudent(new Student(name, subject, mark));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            textField1.clear();
            textField2.clear();
            textField3.clear();

        });

        PieChart pieChart = new PieChart();
        pieChart.setTranslateX(100);
        pieChart.setTranslateY(200);

        button2.setOnAction(actionEvent -> {
            StudentUtils.getAllStudent().forEach(data -> System.out.println(data.subject));
            System.out.println(StudentUtils.getAllStudent());
            pieChart.setData(getData());
        });


        root.getChildren().add(textField1);
        root.getChildren().add(textField2);
        root.getChildren().add(textField3);

        root.getChildren().add(text);
        root.getChildren().add(text2);
        root.getChildren().add(text3);

        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(pieChart);

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("My App");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
    private ObservableList<PieChart.Data> getData(){
        ArrayList<String> subject = new ArrayList<String>();
        ArrayList<Integer> mark = new ArrayList<Integer>();


        StudentUtils.getAllStudent().forEach(data -> subject.add(data.getSubject()));
        StudentUtils.getAllStudent().forEach(data -> mark.add(data.getMark()));
        System.out.println(subject);
        String sub1 = subject.get(0);
        String sub2 = subject.get(1);
        String sub3 = subject.get(2);
        int mar1 = mark.get(0);
        int mar2 = mark.get(1);
        int mar3 = mark.get(2);


        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList(
                new PieChart.Data(sub1, mar1),
                new PieChart.Data(sub2, mar2),
                new PieChart.Data(sub3, mar3)

        );
        return observableList;
    }
}