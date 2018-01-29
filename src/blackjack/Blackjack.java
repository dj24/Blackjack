/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
 
import java.util.Arrays;




public class Blackjack {

    
    public static void main(String[] args) {
        Card card = new Card(Card.Suit.SPADES,Card.Rank.ACE);
        Card a[] = {card};
        Hand hand = new Hand(a);
        hand.add(new Card(Card.Suit.CLUBS,Card.Rank.KING));
        Hand hand2 = new Hand(hand);
        
        Deck deck = new Deck();
        System.out.println(deck.size());
        
        deck.deal();
        System.out.println(deck.size());
        
    }
    
}
