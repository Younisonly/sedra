/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import javafx.scene.control.Menu;

public class LocationMenu extends Menu {
    public LocationMenu() {
        super("Location");

        // Add the menu items
        getItems().addAll(new InsertLocationMenuItem(), new UpdateLocationMenuItem(), new SearchLocationMenuItem());
    }
}
