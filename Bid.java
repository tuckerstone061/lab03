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
public class Bid {

    private final Buyer bidder;
    private final long value;

    public Bid(Buyer bidder, long value) {
        this.bidder = bidder;
        this.value = value;
    }

    public Buyer getBidder() {
        return bidder;
    }

    public long getValue() {
        return value;
    }
}
