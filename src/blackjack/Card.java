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
        TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(10),QUEEN(10),KING(10),ACE(11);
        
        
        //public abstract Rank getPrevious();
        
        private final int value;
        
        Rank(int value){
            this.value = value;
        }
        
        int getValue(){
            return value;
        }
        public Rank getPrevious() {
        return this.ordinal() < Rank.values().length - 1 ? Rank.values()[this.ordinal()-1] 
        : null;
   }
        
    }
    
    enum Suit{
        CLUBS,DIAMONDS,HEARTS,SPADES;
    }
    

}
