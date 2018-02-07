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
    private int BET;
    private Card dealerCard;
    private int cardCount;
    
    public BasicPlayer(){
        balance = 200;
        hand = new Hand();
    }
    
    @Override
    public Hand newHand(){
        Hand oldHand = hand;
        hand = new Hand();
        return oldHand;
    };
    
    public int makeBet(){
        setBet(10);
        return getBet();
    };
    public void setBet(int bet){
        BET = bet;
    }
    
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
        if(hand.getValue() > 21){
            System.out.println("BUST");
            return false;
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
    public int getCardCount(){
        return cardCount;
    }
    public void viewDealerCard(Card c){
        dealerCard = c;
    };
    public Card getDealerCard(){
        return dealerCard;
    }

    public void viewCards(List<Card> cards){       
        for(Card c : cards){
            int value;
            value = c.getValue();
            if(value<=6){
                cardCount++;
            }
            else if(value>=10){
                cardCount--;
            }
            System.out.println("CARD COUNT: " + cardCount);
        }
    };

    public void newDeck(){
        cardCount = 0;
        System.out.println("New deck created");
    };
}
