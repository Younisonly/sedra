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
import javafx.scene.control.ChoiceDialog;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;

public class UpdateLocationMenuItem extends MenuItem {
    public UpdateLocationMenuItem() {
        super("Update");
        setOnAction(new UpdateLocationHandler());
    }

    private class UpdateLocationHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Get the list of locations
            List<Location> locations = LocationList.getInstance().getLocations();

            // Create a list of location names for the ChoiceDialog
            List<String> locationNames = new ArrayList<>();
            for (Location location : locations) {
                locationNames.add(location.getName());
            }

            // Prompt the user to select a location to update
            ChoiceDialog<String> dialog = new ChoiceDialog<>(locationNames.get(0), locationNames);
            dialog.setTitle("Update Location");
            dialog.setHeaderText(null);
            dialog.setContentText("Select a location to update:");
            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                // Get the selected location
                String selectedName = result.get();
                Location selectedLocation = null;
                for (Location location : locations) {
                    if (location.getName().equals(selectedName)) {
                        selectedLocation = location;
                        break;
                    }
                }

                // Prompt the user for the new coordinates
                TextInputDialog inputDialog = new TextInputDialog(selectedLocation.getLatitude() + "," + selectedLocation.getLongitude());
                inputDialog.setTitle("Update Location");
                inputDialog.setHeaderText(null);
                inputDialog.setContentText("Enter the new coordinates (latitude,longitude):");
                Optional<String> inputResult = inputDialog.showAndWait();

                if (inputResult.isPresent()) {
                    String[] parts = inputResult.get().split(",");
                    if (parts.length == 2) {
                        double latitude = Double.parseDouble(parts[0].trim());
                        double longitude = Double.parseDouble(parts[1].trim());
                        selectedLocation.setLatitude(latitude);
                        selectedLocation.setLongitude(longitude);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Location updated successfully.", ButtonType.OK);
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input.", ButtonType.OK);
                        alert.showAndWait();
                    }
                }
            }
        }
    }
}