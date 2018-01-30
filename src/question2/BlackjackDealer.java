/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import question1.*;

/**
 *
 * @author User
 */
public class BlackjackDealer implements Dealer{
    
    private Deck deck;
    private Hand hand;
    public int pot;
    BlackjackTable table;
    
    BlackjackDealer(BlackjackTable table){
        this.table = table;
        this.hand = new Hand();
        this.deck = new Deck();
        deck.shuffle();
    }
    
    public int getPot(){
        return pot;
    }
    
    public void assignPlayers(List<Player> p){
        table.addPlayers(p);
    };
    
    
    public void takeBets(){
        List<Player> players = table.getPlayers();
        for(Player p : players){
            p.makeBet();
        }
    };    

    public void dealFirstCards(){
        for(Player p : table.getPlayers()){
            p.newHand();
            p.takeCard(deck.deal());
            p.takeCard(deck.deal());
        }
        hand.add(deck.deal());
    };

    
    public int play(Player p){
        pot = 0;
        if(deck.size() < 52/4){
            deck.newDeck();
            deck.shuffle();
            p.newDeck();
        }
        boolean checkHit;
            do{
                checkHit = p.hit();
                if(checkHit == true){
                    Card newCard = deck.deal();
                    System.out.println("Dealt " + newCard.toString() + "\n");
                    p.takeCard(newCard);
                }
            }while(checkHit == true);
        return p.getHand().getValue();
    };

  
    public int playDealer(){
        System.out.println("\n------------------------- DEALER"
                + " -------------------------\n");
        System.out.println("Dealer hand: \n" + hand.toString());
        while(hand.getValue() < 17){
            Card newCard = deck.deal();
            hand.add(newCard);
            System.out.println("HIT");
            System.out.println("Dealt " + newCard.toString() + "\n");
        }
        System.out.println("Dealer hand value: " + hand.getValue() + "\n");
        return hand.getValue();
    };
   
    public int scoreHand(Hand h){
        return h.getValue();
    };
    
    
    
    public void settleBets(){
        List<Player> players = table.getPlayers();
        int dealerVal = hand.getValue();
        int index;
        String loss,win,draw,blackjack;
        for (Player p:players){
            index = (players.indexOf(p)+1);
            loss = "Player " + index + " Loses £" + p.getBet();
            draw = "Player " + index +  " Wins £" + 0;
            win = "Player " + index + " Wins £" + p.getBet()*2;
            blackjack = "Player " + index + " Wins £" + p.getBet()*3;
            //bust condition
            if(p.isBust()){
                System.out.println(loss);
            }
            //draw condition
            else if(hand.getSize() == 2 && dealerVal == 21 && p.blackjack() 
                    || dealerVal == scoreHand(p.getHand()))
            {
                p.settleBet(p.getBet());
                System.out.println(draw);
            }
            //blackjack condition
            else if(p.blackjack()){
                p.settleBet(((int)p.getBet()*3));
                System.out.println(blackjack);
            }
            //player has a better score than dealer
            else if( (p.getHandTotal() > dealerVal) || 
                    (!p.isBust() && dealerVal > 21)){
                p.settleBet(p.getBet()*2);
                System.out.println(win);
            }
            //loss condition
             else{
                System.out.println(loss);
            } 
        }
       
    }
}
