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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.MenuItem;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.ChoiceDialog;

public class SearchLocationMenuItem extends MenuItem {
    public SearchLocationMenuItem() {
        super("Search");
        setOnAction(new SearchLocationHandler());
    }

    private class SearchLocationHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Get the list of locations
            List<Location> locations = LocationList.getInstance().getLocations();

            // Create a list of location names for the ChoiceDialog
            List<String> locationNames = new ArrayList<>();
            for (Location location : locations) {
                locationNames.add(location.getName());
            }

            // Prompt the user to select a location to search for
            ChoiceDialog<String> dialog = new ChoiceDialog<>(locationNames.get(0), locationNames);
            dialog.setTitle("Search Location");
            dialog.setHeaderText(null);
            dialog.setContentText("Select a location to search for:");
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

                // Display the selected location's details
                if (selectedLocation != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Name: " + selectedLocation.getName() + "\nLatitude: " + selectedLocation.getLatitude() + "\nLongitude: " + selectedLocation.getLongitude(), ButtonType.OK);
                    alert.setTitle("Location Details");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Location not found.", ButtonType.OK);
                    alert.showAndWait();
                }
            }
        }
    }
}