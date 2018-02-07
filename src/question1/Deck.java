/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * A class to create a deck of cards
 * @author Daniel Jackson
 */
public class Deck implements Serializable, Iterable{
    static final long serialVersionUID = 112;
    private ArrayList<Card> deck = new ArrayList();
    /**
     * Creates a new instance of deck and creates a deck of 52 cards
     */
    public Deck(){
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values())
                deck.add(new Card(suit,rank));
        }
    }
    /**
     * Recreates the deck in its original form
     */
    public final void newDeck(){
        ArrayList<Card> newDeck= new ArrayList<>();
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values())
                newDeck.add(new Card(suit,rank));
        }
        deck = newDeck;
        
    }
    /**
     * Shows the size of the deck
     * @return int - the amount of cards found in the current deck
     */
    public int size(){
        return deck.size();
    }
    
    /**
     * Builds a string containing each card in the deck
     * @return String - Each card printed in its order in the deck
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
 
        for(Card c : deck) {
            str.append(c);
            str.append("\n");
        }
        
        return str.toString();
    }
    
    /**
     * Removes a card from the top of the deck and returns it
     * @return Card - the card that was removed
     */
    public Card deal(){
        return deck.remove(0);
    }
    /**
     * Randomises the order of the cards in the deck
     */
    public void shuffle(){
        int size = deck.size();
        Random random = new Random();
        random.nextInt();
        
        for (int i = 0; i < size; i++) {
            int change = i + random.nextInt(size - i);
            
            // Swap the cards
            Card helper = deck.get(i);
            deck.set(i, deck.get(change));
            deck.set(change, helper);
        } 
    }
    
    /**
     * Serializes the deck and writes to a file
     * @throws java.io.IOException
     */
    public void serialize() throws IOException{ 
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
    
   /**
     * Opens a file and deserializes the deck
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @return Deck - the deserialized deck
     */
    public Deck deserialize() throws IOException, ClassNotFoundException{
        Deck deserialize = null;
        
	try {
            FileInputStream fis = new FileInputStream("deck.ser");
            ObjectInputStream in = new ObjectInputStream(fis);

            deserialize = (Deck)in.readObject();
            
            in.close();
            fis.close();
            
            System.out.println("Deck has been deserialized ");
            
	} 
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
         
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }     
        return deserialize;
    }
    
    /**
    * Iterates over each card in the deck
    */
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
    /**
    * Class to iterate over every other card for serialization
    */
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
        //deck.serialize();
        System.out.println(deck.toString());
        System.out.println("Top card dealt: " + deck.deal().toString());
        System.out.println("\nDeck size :" + deck.size());
        System.out.println("\nNew Deck: ");
        deck.newDeck();
        System.out.println(deck.toString());
        System.out.println("\nNormal iterator:");
        Iterator it = deck.iterator();
        
        while(it.hasNext()){
            Object card = it.next();
            System.out.println(card);
        }
        
        
        
        
        /*
        deck.deserialize();
        
        System.out.println("Deserialized");
        deck.toString();
        */
    }
}

