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
    private Card firstCard;
    private Hand hand;
    private Card firstCard;
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
        firstCard = deck.deal();
<<<<<<< HEAD
        System.out.println("Dealer Card:" + firstCard.toString());
        hand.add(firstCard);
=======
        //System.out.println(firstCard.toString());
        hand.add(firstCard);
        
>>>>>>> b54727b70acc4ea4211d50495ea54dda72dbf702
    };

    
    public int play(Player p){
        p.viewDealerCard(firstCard);
        if(deck.size() < 52/4){
            deck.newDeck();
            deck.shuffle();
            p.newDeck();
        }
        p.viewDealerCard(firstCard);
        boolean checkHit;
            do{
                checkHit = p.hit();
                if(checkHit == true){
                    Card newCard = deck.deal();
                    p.takeCard(newCard);
                }
            }while(checkHit == true);
        return p.getHand().getValue();
    };

  
    public int playDealer(){
        while(hand.getValue() < 17){
            Card newCard = deck.deal();
            hand.add(newCard);
        }
        //System.out.println(hand.toString());
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
            
            //draw condition
            if(hand.getSize() == 2 && dealerVal == 21 && p.blackjack() 
                    || dealerVal == scoreHand(p.getHand()))
            {
                p.settleBet(p.getBet());
            }
            //blackjack condition
            else if(p.blackjack()){
                p.settleBet(((int)p.getBet()*3));
            }
            //player has a better score than dealer
            else if( (p.getHandTotal() > dealerVal) || 
                    (!p.isBust() && dealerVal > 21)){
                p.settleBet(p.getBet()*2);
            }
        }
       
    }
}
