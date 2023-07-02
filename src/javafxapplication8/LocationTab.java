/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class LocationTab extends Tab {
    public LocationTab() {
        super("Location");

        // Create the table view
        TableView<Location> tableView = new TableView<>();
        tableView.setItems(getLocationData());

        // Create the controls
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");

        // Add the controls to a tool bar
        ToolBar toolBar = new ToolBar(addButton, updateButton, deleteButton);

        // Add the table view and tool bar to the tab
        setContent(new VBox(tableView, toolBar));
    }

    private ObservableList<Location> getLocationData(String filePath) {
    ObservableList<Location> locationData = FXCollections.observableArrayList();
    try {
        // Use a FileChooser to allow the user to choose the CSV file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Location Data");
        File file = new File(filePath);
        if (file.exists()) {
            fileChooser.setInitialDirectory(file.getParentFile());
        }
        fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            // Open the selected CSV file using a BufferedReader
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));

            // Read the header line and discard it
            reader.readLine();

            // Read each line of the CSV file and create a Location object for each line
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                double latitude = Double.parseDouble(fields[1]);
                double longitude = Double.parseDouble(fields[2]);
                Location location = new Location(name);
                locationData.add(location);
            }

            // Close the BufferedReader
            reader.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return locationData;
}

    private ObservableList<Location> getLocationData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
