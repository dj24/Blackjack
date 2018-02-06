/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author User
 */
public class Deck implements Serializable, Iterable{
    static final long serialVersionUID = 112;
    private ArrayList<Card> deck = new ArrayList();;
    
    public Deck(){
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values())
                deck.add(new Card(suit,rank));
        }
        
    }
    
    public final void newDeck(){
        ArrayList<Card> newDeck= new ArrayList<>();
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values())
                newDeck.add(new Card(suit,rank));
        }
        deck = newDeck;
        
    }
    
    public int size(){
        return deck.size();
    }
    
    @Override
    public String toString(){
        String out = "";
        for(Card c : deck)
            out = out.concat(c.toString() + "\n");
        return out;
    }
    
    public Card deal(){
        return deck.remove(0);
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }
    
    public boolean isOver(int a){
        return 2<a;
    }
    
        public void serialise() {
        
        try {
            FileOutputStream fos = new FileOutputStream("deck.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(deck);
            
            out.close();
            fos.close();
            
            System.out.println("Serialized data is saved in deck.ser");
        }
         catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
   }
    
   
    public void deserialise() {
        Deck deserialise = null;
        
	try {
            FileInputStream fis = new FileInputStream("deck.ser");
            ObjectInputStream in = new ObjectInputStream(fis);

            deserialise = (Deck)in.readObject();
            
            in.close();
            fis.close();
            
            System.out.println("Deck has been deserialized ");
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
                if (index < deck.size())
                    return true;
                return false;
            }
            
            @Override
            public Card next() {
                if (hasNext())
                    return (Card) deck.toArray()[index++]; 
                return null;
            }
        };
        return it;
    }
    class SecondCardIterator{
        
        public Iterator<Card> iterator() {
            Iterator<Card> it = new Iterator<Card>() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    if (index < deck.size())
                        return true;
                    return false;
                }

                @Override
                public Card next() {
                    if (hasNext())
                        return (Card) deck.toArray()[index+=2]; 
                    return null;
                }
            };
            return it;
        }
    }
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("New Deck:");
        System.out.println(deck.toString());
        System.out.println("\nShuffled: ");
        deck.shuffle();
        //deck.serialise();
        System.out.println(deck.toString());
        System.out.println("Top card dealt: " + deck.deal().toString());
        System.out.println("Deck size :" + deck.size());
        System.out.println("New Deck: ");
        deck.newDeck();
        System.out.println(deck.toString());
        /*
        deck.deserialise();
        
        System.out.println("Deserialised");
        deck.toString();
        */
    }
}

