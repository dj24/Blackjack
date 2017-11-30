/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author User
 */
public class Card {
    enum Rank{
        TWO(2){
            public Rank getPrevious() { return ACE; }
        },THREE(3){
            public Rank getPrevious() { return ACE; }
        },FOUR(4){
            public Rank getPrevious() { return ACE; }
        },FIVE(5){
            public Rank getPrevious() { return ACE; }
        },SIX(6){
            public Rank getPrevious() { return ACE; }
        },SEVEN(7){
            public Rank getPrevious() { return ACE; }
        },EIGHT(8){
            public Rank getPrevious() { return ACE; }
        },NINE(9){
            public Rank getPrevious() { return ACE; }
        },TEN(10){
            public Rank getPrevious() { return ACE; }
        },JACK(10){
            public Rank getPrevious() { return ACE; }
        },QUEEN(10){
            public Rank getPrevious() { return ACE; }
        },KING(10){
            public Rank getPrevious() { return ACE; }
        },ACE(11){
            public Rank getPrevious() { return ACE; }
        };
        
        //public abstract Rank getPrevious();
        
        private final int value;
        
        Rank(int value){
            this.value = value;
        }
        
        int getValue(){
            return value;
        }
    }
    
    enum Suit{
        CLUBS,DIAMONDS,HEARTS,SPADES;
    }
    

}
