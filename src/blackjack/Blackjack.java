/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
 
import java.util.Arrays;




public class Blackjack {

    
    public static void main(String[] args) {
        Card card = new Card(Card.Suit.CLUBS,Card.Rank.ACE);
        Card a[] = {card};
        Hand hand = new Hand(a);
        Hand hand2 = new Hand(hand.deserialise());
        System.out.println(hand2.toString());
        
    }
    
}
