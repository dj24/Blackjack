/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author User
 */
public class Deck {
    private List<Card> deck;
    
    Deck(){
        List<Card> newDeck= new ArrayList<Card>();
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
}

