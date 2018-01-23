/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
 
import java.util.Arrays;




public class Blackjack {

    
    public static void main(String[] args) {
        Deck deck = new Deck();
        
        deck.shuffle();
        
        
        System.out.println(deck.toString());
        
    }
    
}
