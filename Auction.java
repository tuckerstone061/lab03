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
public class Auction {

    private Bid highestBid;
    private Buyer currentBuyer;
    private Seller theSeller;
    private Item forSale;

    public Auction(Seller newSeller, Item newSale) {
        this.currentBuyer = null;
        this.theSeller = newSeller;
        this.forSale = newSale;
        this.highestBid = null;
    }

    public boolean placeBid(Bid bid) {
        if (this.highestBid == null) {
            this.highestBid = bid;
            this.currentBuyer = bid.getBidder();
            return true;
        } else if (bid.getValue() > highestBid.getValue()) {
            highestBid = bid;
            this.currentBuyer = bid.getBidder();
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.forSale.toString() + "\nCurrent highest bidder: " + this.currentBuyer.getUserID() + "\nCurrent Bid: "
                + this.highestBid.getValue() + "\nSold by: " + this.theSeller.getUserID() + "\n\n";
    }
}
