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
public class Member {

    private String userID;
    private String password;
    private String email;
    private String creditCard;

    public Member(String newID, String newPass, String newEmail, String newCard) {
        this.userID = newID;
        this.password = newPass;
        this.email = newEmail;
        this.creditCard = newCard;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCreditCard() {
        return this.creditCard;
    }

    public String toString() {
        return getUserID();
    }

    public boolean validate(String toCheck) {
        return this.password.equals(toCheck);
    }
}
