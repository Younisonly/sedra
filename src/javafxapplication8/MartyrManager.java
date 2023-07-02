/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;

public class MartyrManager {
    private List<Martyr> martyrs;
    private AVLTree avlTree1;
    private AVLTree avlTree2;

    public MartyrManager() {
        this.martyrs = new ArrayList<>();
        this.avlTree1 = new AVLTree();
        this.avlTree2 = new AVLTree();
    }

    public void addMartyr(Martyr martyr) {
        martyrs.add(martyr);
        avlTree1.insert(martyr.getName(), martyr);
        avlTree2.insert(martyr.getDateOfDeath(), martyr);
    }

    public void updateMartyr(Martyr martyr, String newName, int newAge, String newEventLocation, String newDistrict, LocalDate newDateOfDeath, Gender newGender) {
        // Update an existing martyr in the list
        martyr.setName(newName);
        martyr.setAge(newAge);
        martyr.setEventLocation(newEventLocation);
        martyr.setDistrict(newDistrict);
        martyr.setDateOfDeath(newDateOfDeath);
        martyr.setGender(newGender);

        // Update the AVL trees
        avlTree1.delete(martyr.getName());
        avlTree2.delete(martyr.getDateOfDeath());
        avlTree1.insert(martyr.getName(), martyr);
        avlTree2.insert(martyr.getDateOfDeath(), martyr);
    }

    public void removeMartyr(Martyr martyr) {
        martyrs.remove(martyr);
        avlTree1.delete(martyr.getName());
        avlTree2.delete(martyr.getDateOfDeath());
    }

    public List<Martyr> searchMartyrsByName(String name) {
        // Search for martyrs by name using AVL tree 1
        List<Martyr> result = new ArrayList<>();
        List<Nodes> nodes = avlTree1.search(name);
        for (Nodes node : nodes) {
            result.add((Martyr) node.getValue());
        }
        return result;
    }

    public List<Martyr> searchMartyrsByDate(LocalDate date) {
        // Search for martyrs by date of death using AVL tree 2
        List<Martyr> result = new ArrayList<>();
        List<Nodes> nodes = avlTree2.search(date);
        for (Nodes node : nodes) {
            result.add((Martyr) node.getValue());
        }
        return result;
    }

    public List<Martyr> getMartyrs() {
        return martyrs;
    }

    public void setMartyrs(List<Martyr> martyrs) {
        this.martyrs = martyrs;
    }

    @Override
    public String toString() {
        return "MartyrManager{" +
                "martyrs=" + martyrs +
                ", avlTree1=" + avlTree1 +
                ", avlTree2=" + avlTree2 +
                '}';
    }
}