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
        
        hand.add(firstCard);

        System.out.println(firstCard.toString());
        hand.add(firstCard);
        

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
                    System.out.println("Player  was dealt:" + newCard.toString());
                    p.takeCard(newCard);
                }
            }while(checkHit == true);
        return p.getHand().getValue();
    };

  
    public int playDealer(){
        System.out.println(hand.toString());
        while(hand.getValue() < 17){
            System.out.println("HIT");
            Card newCard = deck.deal();
            System.out.println("Dealt " + newCard.toString());
            hand.add(newCard);
        }
        if(hand.getValue() > 17)
            System.out.println("STICK");
        if(hand.getValue() > 21)
            System.out.println("BUST");
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
            loss = "Lost £" + p.getBet();
            win = "Won £" + p.getBet();
            draw = "Draw";
            blackjack = "Blackjack! Won £" + p.getBet()*2;
            index = (players.indexOf(p)+1);
            if(dealerVal > 21){
                //dealer bust
                System.out.println(win);
                p.settleBet((int)p.getBet());
            }
            //draw condition
            else if(hand.getSize() == 2 && dealerVal == 21 && p.blackjack() 
                    || dealerVal == scoreHand(p.getHand()))
            {
                p.settleBet(0);
                System.out.println(draw);
            }
            //blackjack condition
            else if(p.blackjack()){
                p.settleBet(((int)p.getBet()*2));
                System.out.println(blackjack);
            }
            //player has a better score than dealer
            else if( (p.getHandTotal() > dealerVal) || 
                    (!p.isBust() && dealerVal > 21)){
                System.out.println(win);
                p.settleBet(p.getBet());
            }
            else
            {
                //loss condition
                p.settleBet(-p.getBet());
                System.out.println(loss);
            }
        }
       
    }
}
