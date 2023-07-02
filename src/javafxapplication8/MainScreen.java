package javafxapplication8;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MainScreen extends StackPane {
    
    public MainScreen() {
        Button helloButton = new Button("Say 'Hello World'");
        helloButton.setOnAction(event -> System.out.println("Hello World!"));

        getChildren().add(helloButton);
    }
    
}
