module com.example.java_final_prep {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.java_final_prep to javafx.fxml;
    exports com.example.java_final_prep;
}