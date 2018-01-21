/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
 
import static blackjack.Card.Rank.isBlackJack;


public class Blackjack {

    
    public static void main(String[] args) {
        Card card = new Card();
        System.out.println(isBlackJack(Card.Rank.ACE,Card.Rank.ACE));
        
    }
    
}
