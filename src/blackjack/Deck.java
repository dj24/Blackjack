/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Deck {

    public enum Rank{
        TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(10),QUEEN(10),KING(10),ACE(11);

        private final int value;

        Rank(int value){
            this.value = value;
        }

        int getValue(){
            return value;
        }
        
        
    }
    
    public enum Suit{
            CLUBS,DIAMONDS,HEARTS,SPADES;
    }
    
    private ArrayList<Card> deck;
    
    public static class Card {

        private Suit suit;
        private Rank rank;

        private Card(Suit suit, Rank rank){
            this.suit = suit;
            this.rank  = rank;
        }
        
        public Rank rank() {return rank;}
        public Suit suit() {return suit;}

    }

}
