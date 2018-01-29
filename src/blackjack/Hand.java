/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        serialise();
    }
    
    public Hand(Hand newHand){
        this.rankCount = new int[13];
        this.handValue = 0;
        this.hand = new ArrayList();
        for(Object c : newHand)
            hand.add((Card)c);
        serialise();
    }
    /*
    public ArrayList<Integer> getValues(){
        return values;
    }
    */
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
            if(hand.contains((Card)newCard)){
                hand.remove((Card)newCard);
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
        return 2<a;
    }
    
    public void serialise() {
        
        try {
            FileOutputStream fos = new FileOutputStream("hand.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);

            Hand serialise = new Hand();
            for (Card card : hand) {
                serialise.add(card);
            }

            out.writeObject(serialise);
            out.close();
            fos.close();
        }
         catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
   }
    
   
    public void deserialise() {
        Hand deserialise = null;
        
	try {
            FileInputStream fis = new FileInputStream("hand.ser");
            ObjectInputStream in = new ObjectInputStream(fis);

            deserialise = (Hand)in.readObject();
            
            in.close();
            fis.close();
            
            System.out.println("Object has been deserialized ");
            System.out.println(deserialise);
            
	} 
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
         
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }     
        
    }
    
    @Override
    public Iterator<Card> iterator() {
        Iterator<Card> it = new Iterator<Card>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (index < hand.size())
                    return true;
                return false;
            }
            
            @Override
            public Card next() {
                if (hasNext())
                    return (Card) hand.toArray()[index++]; 
                return null;
            }
        };
        return it;
    }
    
    @Override
    public String toString(){
        String out = "";
        for(Card c : hand)
            out = out.concat(c.toString() + "\n");
        return out;
    }
    
}
