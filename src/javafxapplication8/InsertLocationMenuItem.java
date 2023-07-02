/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
import javafx.scene.control.MenuItem;

public class InsertLocationMenuItem extends MenuItem {
    public InsertLocationMenuItem() {
        super("Insert");
        setOnAction(new InsertLocationHandler());
    }

    private class InsertLocationHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Prompt the user for a location name and coordinates
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Insert Location");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter the location name and coordinates (latitude,longitude):");
            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                String[] parts = result.get().split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    double latitude = Double.parseDouble(parts[1].trim());
                    double longitude = Double.parseDouble(parts[2].trim());
Location location = new Location(name);                    // Add the new location to the list
                    LocationList.getInstance().addLocation(location);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Location added successfully.", ButtonType.OK);
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input.", ButtonType.OK);
                    alert.showAndWait();
                }
            }
        }
    }
}
