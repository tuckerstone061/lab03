/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionhouse;

import java.util.*;
import java.io.*;

/**
 *
 * @author Tucker Stone
 */
public class AuctionHouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buyer user;
        Buyer[] buyers = new Buyer[6];
        Buyer buyer1 = new Buyer("Buyer1", "askgljasklg", "b1@gmail.com", "122233333");
        buyers[0] = buyer1;
        Buyer buyer2 = new Buyer("Buyer2", "askgljasklg", "b2@gmail.com", "122233333");
        buyers[1] = buyer2;
        Buyer buyer3 = new Buyer("Buyer3", "askgljasklg", "b3@gmail.com", "122233333");
        buyers[2] = buyer3;
        Buyer buyer4 = new Buyer("Buyer4", "askgljasklg", "b4@gmail.com", "122233333");
        buyers[3] = buyer4;
        Buyer buyer5 = new Buyer("Buyer5", "askgljasklg", "b5@gmail.com", "122233333");
        buyers[4] = buyer5;
        Buyer buyer6 = new Buyer("Buyer6", "askgljasklg", "b6@gmail.com", "122233333");
        buyers[5] = buyer6;
        Seller theSeller = new Seller("George Bush", "asgkjasklgjsa", "gdubya@gov.com", "");
        user = initUser();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
// handle the exception...
// For example consider calling Thread.currentThread().interrupt(); here.
        }
        login(user);
        try {
            getItems(theSeller);
        } catch (FileNotFoundException ie) {
            ie.printStackTrace();
        }
        auctionItems(user, buyers, theSeller);
        System.out.println("\nThanks for playing!!");
    }

    public static void login(Buyer user) {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.println("Please login to continue");
            System.out.print("Name: ");
            String name = scan.nextLine();
            System.out.print("\nPassword: ");
            String pass = scan.nextLine();
            System.out.println();
            if (name.equals(user.getUserID()) && user.validate(pass) == true) {
                valid = true;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
// handle the exception...
// For example consider calling Thread.currentThread().interrupt(); here.
        }
        System.out.println("Thank you! Login successful!\n\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
// handle the exception...
// For example consider calling Thread.currentThread().interrupt(); here.
        }
    }

    public static Buyer initUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scan.nextLine();
        System.out.println("Please enter your password");
        String password = scan.nextLine();
        System.out.println("Please enter your email");
        String email = scan.nextLine();
        System.out.println("Please enter your credit card");
        String creditCard = scan.nextLine();
        return new Buyer(name, password, email, creditCard);
    }

    public static void getItems(Seller theSeller) throws FileNotFoundException {
        File file = new File("in.txt");
        Scanner scan = new Scanner(file);
        int numItems = 11;
        for (int i = 0; i < numItems; i++) {
            String name = scan.nextLine();
            String description = scan.nextLine();
            Item temp = new Item(name, description);
            theSeller.addItem(temp);
        }
    }

    public static void auctionItems(Buyer user, Buyer[] buyers, Seller theSeller) {
        int numItems = theSeller.getForSale().size();
        Auction currentAuc;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < numItems; i++) {
            System.out.println("Next item:");
            currentAuc = new Auction(theSeller, theSeller.listItem(i));
            for (int j = 0; j < buyers.length; j++) {
                currentAuc.placeBid(buyers[j].randBid(buyers[j]));
            }
            System.out.println(currentAuc.toString());
            System.out.println("Would you like to bid on this item? (y/n)");
            String answer = scan.nextLine();
            if (answer.equals("y") || answer.equals("Y")) {
                System.out.println("Please enter a bid price\n");
                Bid userBid = new Bid(user, scan.nextInt());
                scan.nextLine();
                boolean win = currentAuc.placeBid(userBid);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
// handle the exception...
// For example consider calling Thread.currentThread().interrupt(); here.
                }
                if (win) {
                    System.out.println("\n***Congratulations! You won the item!***\n");
                    user.addItem(theSeller.listItem(i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
// handle the exception...
// For example consider calling Thread.currentThread().interrupt(); here.
                    }
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
// handle the exception...
// For example consider calling Thread.currentThread().interrupt(); here.
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
// handle the exception...
// For example consider calling Thread.currentThread().interrupt(); here.
        }
        System.out.println("\nCongratulations! You won: ");
        for (int i = 0; i < user.getItems().size(); i++) {
            System.out.println(user.getItem(i));
            System.out.println();
        }
    }
}
