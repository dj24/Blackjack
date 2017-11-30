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
        TWO(2){
            public Rank getPrevious() { return ACE; }
        },THREE(3){
            public Rank getPrevious() { return TWO; }
        },FOUR(4){
            public Rank getPrevious() { return THREE; }
        },FIVE(5){
            public Rank getPrevious() { return FOUR; }
        },SIX(6){
            public Rank getPrevious() { return FIVE; }
        },SEVEN(7){
            public Rank getPrevious() { return SIX; }
        },EIGHT(8){
            public Rank getPrevious() { return SEVEN; }
        },NINE(9){
            public Rank getPrevious() { return EIGHT; }
        },TEN(10){
            public Rank getPrevious() { return NINE; }
        },JACK(10){
            public Rank getPrevious() { return TEN; }
        },QUEEN(10){
            public Rank getPrevious() { return JACK; }
        },KING(10){
            public Rank getPrevious() { return QUEEN; }
        },ACE(11){
            public Rank getPrevious() { return KING; }
        };

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
