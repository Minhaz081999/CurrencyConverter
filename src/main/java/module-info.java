module com.example.practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.net.http;
    requires json.simple;
    requires org.json;


    opens com.example.practice to javafx.fxml;
    exports com.example.practice;
}