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
import java.util.Comparator;
import java.util.Iterator;

/**
 * A class to create a hand of cards
 * @author Daniel Jackson
 */
public class Hand implements Serializable, Iterable{
    
    static final long serialVersionUID = 102;
    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();
    private int[] rankCount;
    private int value;
    
    /**
    * Default constructor to initialise a hand of cards
    */
    public Hand() {
        this.rankCount = new int[13];
        this.value = 0;
        this.hand = new ArrayList();
    }
    /**
    * Constructor to initialise a hand of cards
    * @param c - Card to add to the hand 
    */
     public Hand(Card c) {
        this.rankCount = new int[13];
        this.value = 0;
        hand.add(c);
    }
    /**
    * Constructor to initialise a hand of cards
    * @param cards - Array of cards to add to the hand 
    */
    public Hand(Card[] cards){
        this.rankCount = new int[13];
        this.value = 0;
        for(Card c : cards)
            hand.add(c);
    }
    /**
    * Constructor to initialise a hand of cards
    * @param newHand - Hand to add to the hand 
    */
    public Hand(Hand newHand) throws IOException{
        this.rankCount = new int[13];
        this.value = 0;
        this.hand = new ArrayList();
        for(Object c : newHand)
            hand.add((Card)c);

    }
   /**
    * Gets size of arraylist of cards in hand
    * @return int - quantity of cards in the hand
    */
    public int getSize(){
        return hand.size();
    }
    
    /**
    * Counts number of a specified rank in hand
    * @param givenRank - specified rank to search for
    * @return int - quantity of cards of specified rank
    */
    public int countRank(Card.Rank givenRank) {
        int rankTotal = 0;
   
        for (Card card : hand) {
            Card.Rank rank = card.getRank();
            
            if(givenRank == rank)
                rankTotal++;               
        }     
        return rankTotal;
    }
    
    /**
    * Gets the sum of value of cards in hand
    * @return int - value of cards in the hand
    */
    public int getValue(){
        int value = 0;
        for(Card c: hand){
            if(c.getValue() == 11 && value > 10)
                value ++;
            else{
                value += c.getValue();
            }
        }
        return value;
    }
    /**
    * Gets the sum of soft value of cards in hand (ace low)
    * @return int - value of cards in the hand 
    */
    public int getSoftValue(){

        int value = 0;
        for(Card c: hand){
            if(c.getValue() == 11)
                value ++;
            else{
                value += c.getValue();
            }
        }
        return value;
    }
    /**
    * Gets the sum of hard value of cards in hand (ace high)
    * @return int - value of cards in the hand 
    */
    public int getHardValue(){
        int value = 0;
        for(Card c: hand)
            value += c.getValue();

        return value;
    }
    /**
    * Gets a Card from the hand arraylist
    * @param index - position for the card to be taken from
    * @return Card - Card from arraylist at specified index
    */
    public Card getCard(int index){
        return hand.get(index);
    }
    /**
    * Adds a card to the Hand
    * @param card - card to be added
    */
    public void add(Card card){
        this.hand.add(card);
        increment(card);
    }
    /**
    * Adds a collection of cards to the Hand
    * @param cards - cards to be added 
    */
    public void add(Collection<Card> cards){
        for(Card c : cards)
            hand.add(c);
    }
    /**
    * Adds a hand to the Hand
    * @param hand - hand to be added 
    */
    public void add(Hand hand){
        for(Object c : hand){
            hand.add((Card)c);
            increment((Card)c);
        }
    }
    /**
    * Removes a Card from the hand
    * @param card - card to be removed 
    */
    public boolean remove(Card card){
        if(hand.contains(card)){
            decrement((Card)card);
            hand.remove(card);
            return true;
        }
        return false;
    }
    /**
    * Removes a Hand from the hand
    * @param newHand - card to be removed 
    */
    public boolean remove (Hand newHand){
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
    /**
    * Adjusts value of Hand after removing a card
    * @param card - card that has been removed
    */
    public void decrement(Card card){
        value -=card.getRank().getValue();
        rankCount[card.getOrdinal()]--;
    }
    /**
    * Adjusts value of Hand after adding a card
    * @param card - card that has been added
    */
    public void increment(Card card){
        value +=card.getRank().getValue();
        rankCount[card.getOrdinal()]++;
    }
    /**
     * Checks whether a param a is greater than 2
     * @return boolean - if the passed value is greater than 2, true
     */
    public boolean isOver(int a){
        return 2<a;
    }
    /**
     * Serializes the hand and writes to a file
     * @throws java.io.IOException
     */
    public void serialize() throws IOException{
        
        try {
            FileOutputStream fos = new FileOutputStream("hand.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);

            Hand serialize = new Hand();
            for (Card card : hand) {
                serialize.add(card);
            }

            out.writeObject(serialize);
            out.close();
            fos.close();
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
     * @return Hand - the deserialized deck
     */
    public Hand deserialize() throws IOException, ClassNotFoundException{
        Hand deserialize = null;
        
	try {
            FileInputStream fis = new FileInputStream("hand.ser");
            ObjectInputStream in = new ObjectInputStream(fis);

            deserialize = (Hand)in.readObject();
            
            in.close();
            fis.close();
            
            System.out.println("Object has been deserialized ");
            
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
    * Iterates over each card in the hand
    */
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
    /**
     * Builds a string containing each card in the hand 
     * @return String - Each card printed in its order in the hand
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
 
        for(Card c: hand) {
            str.append(c);
            str.append("\n");
        }
        
        return str.toString();
    }
    /**
     * Reverses order of hand and returns it
     * @return Hand - current hand in reverse order
     */
    public Hand reverse(){
        ArrayList<Card> reverse = hand;
        Collections.reverse(reverse);
        Hand newHand = new Hand();
        for(Card c:reverse){
            newHand.add(c);
        }
        return newHand;
    }
    
    public void sortDescending(){
        
    }
    
    public void sortAscending(){
        Comparator cmpAsc = new Card.compareAscending();
        Collections.sort(hand,cmpAsc);
    }
    public static void main(String[] args) {
        Card c1 = new Card(Card.Suit.CLUBS,Card.Rank.ACE);
        Card c2 = new Card(Card.Suit.SPADES,Card.Rank.EIGHT);
        Card c3 = new Card(Card.Suit.HEARTS,Card.Rank.FOUR);
        Hand hand = new Hand(c1);
        System.out.println("Hand with one card: ");
        System.out.println(hand.toString());
        System.out.println("Hand with cards added: ");
        hand.add(c2);
        hand.add(c3);
        System.out.println(hand.toString());
        System.out.println("Hand with order reversed: ");
        
        System.out.println(hand.reverse().toString());
        
        System.out.println("Hand with card removed: ");
        hand.remove(c2);
        //System.out.println("Hand with itself added: ");
        //hand.add(hand);
        System.out.println(hand.toString());
        hand.remove(c3);
        hand.add(c2);
        hand.add(c3);
        System.out.println("Count of ACE");
        System.out.println(hand.countRank(Card.Rank.ACE));
        System.out.println("\nHand sorted ascending: ");
        hand.sortAscending();
        System.out.println(hand.toString());
    }
    
}
