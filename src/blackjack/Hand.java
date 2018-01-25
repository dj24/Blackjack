/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author User
 */
public class Hand implements Serializable, Iterable{
    static final long serialVersionUID = 102;
    ArrayList<Card> hand = new ArrayList<>();
    private int[] rankCount;
    private int[] suitCount;
    private int handValue;
    
    public Hand() {
        this.suitCount = new int[13];
        this.rankCount = new int[13];
        this.handValue = 0;
        this.hand = new ArrayList();
    }
    
    public Hand(Card[] cards){
        this.suitCount = new int[13];
        this.rankCount = new int[13];
        this.handValue = 0;
        for(Card c : cards)
            hand.add(c);
    }
    
    public Hand(Hand newHand){
        this.suitCount = new int[13];
        this.rankCount = new int[13];
        this.handValue = 0;
        this.hand = new ArrayList();
        for(Object c : newHand)
            hand.add((Card)c);
    }
    
}
