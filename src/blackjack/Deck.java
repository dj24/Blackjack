/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    private ArrayList<Card> deck;
    
    Deck(){
        ArrayList<Card> newDeck= new ArrayList<Card>();
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values())
                newDeck.add(new Card(suit,rank));
        }
        deck = newDeck;
    }
    
    @Override
    public String toString(){
        String out = "";
        for(Card c : deck)
            out = out.concat(c.toString() + "\n");
        return out;
    }
    
    void shuffle(){
        Collections.shuffle(deck);
    }
    
    public boolean isOver(int a){
        return 2<a;
    }
    
        public void serialise() {
        
        try {
            FileOutputStream fos = new FileOutputStream("hand.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);

            ArrayList<Card> serialise = new ArrayList<>();
            Iterator it = hand.iterator();
            while(it.hasNext()) {
                Card card = (Card) it.next();
                serialise.add(card);
              }

            out.writeObject(this);
            out.close();
        }
        catch (Exception ex) {
        }
   }
    
   
    public Hand deserialise() {
        Hand serialise = null;

	try (ObjectInputStream o
		= new ObjectInputStream(new FileInputStream("hand.ser"))){

            serialise = (Hand)o.readObject();
            
	} catch (Exception ex) {
	}     
        
	return serialise;
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
}

