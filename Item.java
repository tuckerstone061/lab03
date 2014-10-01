/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionhouse;

/**
 *
 * @author sstoneman1
 */
public class Item {

    private String name;
    private String description;

    public Item(String newName, String newDescription) {
        this.name = newName;
        this.description = newDescription;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return this.getName() + "\n" + this.getDescription();
    }
}
