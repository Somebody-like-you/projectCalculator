module org.example.projectcalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires exp4j;
    requires java.xml;


    opens org.example.projectcalculator to javafx.fxml;
    exports org.example.projectcalculator;
}