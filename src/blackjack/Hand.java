/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class Hand implements Serializable, Iterable{
    
    static final long serialVersionUID = 102;
    ArrayList<Card> hand = new ArrayList<>();
    private int[] rankCount;
    private int handValue;
    
    public Hand() {
        this.rankCount = new int[13];
        this.handValue = 0;
        this.hand = new ArrayList();
    }
    
    public Hand(Card[] cards){
        this.rankCount = new int[13];
        this.handValue = 0;
        for(Card c : cards)
            hand.add(c);
    }
    
    public Hand(Hand newHand){
        this.rankCount = new int[13];
        this.handValue = 0;
        this.hand = new ArrayList();
        for(Object c : newHand)
            hand.add((Card)c);
    }
    
    void add(Card card){
        this.hand.add(card);
    }
    
    void add(Collection<Card> cards){
        for(Card c : cards)
            hand.add(c);
    }
    
    void add(Hand hand){
        for(Object c : hand)
            hand.add((Card)c);
    }
    
    boolean remove(Card card){
        if(hand.contains(card)){
            hand.remove(card);
            return true;
        }
        return false;
    }
    
    boolean remove (Hand newHand){
        int removedCards = 0;
        for(Object newCard : newHand)
            if(hand.contains(newCard)){
                decrement((Card)newCard);
                hand.remove(newCard);
                removedCards++;
                return true;
            }
        return false;
        }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void decrement(Card card){
        handValue -=card.getRank().getValue();
    }
    
}
