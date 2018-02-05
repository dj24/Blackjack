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
    private int BET = 10;
    private Card dealerCard;
    
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
        return BET;
    };
    
    public int getBet(){
        return BET;
    };

    public int getBalance(){
        return balance;
    };

    public boolean hit(){
        if(hand.getValue() < 17){
            System.out.println("HIT");
            return true;
        }
        System.out.println("STICK");
        return false;
    };

    public void takeCard(Card c){
        hand.add(c);
    };

    public boolean settleBet(int p){
        balance += p;
        return balance > 0;
    };

    public int getHandTotal(){
        return hand.getValue();
    };

    public boolean blackjack(){
        if(hand.getSize() == 2)
            return Card.isBlackJack(hand.getCard(0),hand.getCard(1));
        return false;
    };

    public boolean isBust(){
        if(hand.getValue() > 21){
            return true;
        }
        return false;
    };

    public Hand getHand(){
        return hand;
    };

    public void viewDealerCard(Card c){
        dealerCard = c;
    };

    public void viewCards(List<Card> cards){
        cards.toString();
    };

    public void newDeck(){
        System.out.println("New deck created");
    };
}
