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
    ArrayList<Integer> values = new ArrayList<>();
    private int[] rankCount;
    private int handValue = 0;
    
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
    
    public ArrayList<Integer> getValues(){
        return values;
    }
    
    int getSize(){
        return hand.size();
    }
    
    
    
    
    void addValue(Card newCard){
        
    }
    
    void add(Card card){
        this.hand.add(card);
        increment(card);
    }
    
    void add(Collection<Card> cards){
        for(Card c : cards)
            hand.add(c);
    }
    
    void add(Hand hand){
        for(Object c : hand){
            hand.add((Card)c);
            increment((Card)c);
        }
    }
    
    boolean remove(Card card){
        if(hand.contains(card)){
            decrement((Card)card);
            hand.remove(card);
            return true;
        }
        return false;
    }
    
    boolean remove (Hand newHand){
        int removed = 0;
        for(Object newCard : newHand)
            if(hand.contains(newCard)){
                hand.remove(newCard);
                decrement((Card)newCard);
                removed++;
            }
        if(removed == newHand.getSize())
            return true;
        return false;
    }

    public void decrement(Card card){
        handValue -=card.getRank().getValue();
        rankCount[card.getOrdinal()]--;
    }
    
    public void increment(Card card){
        handValue +=card.getRank().getValue();
        rankCount[card.getOrdinal()]++;
    }
    
    public boolean isOver(int a){
        
    }
    
    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        String out = "";
        for(Card c : hand)
            out = out.concat(c.toString() + "\n");
        return out;
    }
    
}
