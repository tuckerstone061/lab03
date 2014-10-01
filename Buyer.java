/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionhouse;

import java.util.*;

/**
 *
 * @author sstoneman1
 */
public class Buyer extends Member {

    private ArrayList<Item> boughtItems;

    public Buyer(String newID, String newPass, String newEmail, String newCard) {
        super(newID, newPass, newEmail, newCard);
        this.boughtItems = new ArrayList<Item>();
    }

    public void addItem(Item toAdd) {
        boughtItems.add(toAdd);
    }

    public ArrayList<Item> getItems() {
        return this.boughtItems;
    }

    public Item getItem(int index) {
        return this.boughtItems.get(index);
    }

    public Bid randBid(Buyer current) {
        Random rand = new Random();
        long value = rand.nextInt(10) + 1;
        return new Bid(current, value);
    }
}
