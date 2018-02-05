/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
 
import java.util.Arrays;
import question1.*;
import question2.*;




public class Blackjack {

    
    public static void main(String[] args) {
        
        Card card = new Card(Card.Suit.HEARTS,Card.Rank.ACE);
        Hand hand = new Hand(card);
        System.out.println(hand.getSoftValue());
    }
    
}
