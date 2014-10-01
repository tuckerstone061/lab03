/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionhouse;

import java.util.ArrayList;

/**
 *
 * @author sstoneman1
 */
public class Seller extends Member {

    private ArrayList<Item> forSale;

    public Seller(String newID, String newPass, String newEmail, String newCard) {
        super(newID, newPass, newEmail, newCard);
        this.forSale = new ArrayList<Item>();
    }

    public void addItem(Item toAdd) {
        this.forSale.add(toAdd);
    }

    public Item listItem(int index) {
        return this.forSale.get(index);
    }

    public Item removeItem(int index) {
        return this.forSale.remove(index);
    }

    public ArrayList<Item> getForSale() {
        return this.forSale;
    }
}
