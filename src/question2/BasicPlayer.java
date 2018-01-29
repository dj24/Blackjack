/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.List;
import question1.*;

/**
 *
 * @author User
 */
public class BasicPlayer implements Player{
    
    private Hand hand;
    private int balance;
    
    public BasicPlayer(){
        balance = 200;
        hand = new Hand();
    }
    
    public Hand newHand(){
        Hand oldHand = hand;
        hand = new Hand();
        return oldHand;
    };
    
    public int makeBet(){
        return 0;
    };
    
    public int getBet(){
        return 0;
    };

    public int getBalance(){
        return balance;
    };

    public boolean hit(){
        return false;
    };

    public void takeCard(Card c){
        hand.add(c);
    };

    public boolean settleBet(int p){
        return false;
    };

    public int getHandTotal(){
        return 0;
    };

    public boolean blackjack(){
        return false;
    };

    public boolean isBust(){
        return false;
    };

    public Hand getHand(){
        return hand;
    };

    public  void viewDealerCard(Card c){
        
    };

    public  void viewCards(List<Card> cards){
        
    };

    public  void newDeck(){
        
    };
}
