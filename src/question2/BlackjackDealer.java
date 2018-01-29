/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.ArrayList;
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
            table.setPot(table.getPot() + p.getBet());
            System.out.println("\nPot total: " + table.getPot());
        }
    };    

    public void dealFirstCards(){
        for(Player p : table.getPlayers()){
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
        System.out.println("Dealer hand: " + hand.toString());
        while(hand.getValue() < 17){
            Card newCard = deck.deal();
            hand.add(newCard);
            System.out.println("HIT(dealer)");
             System.out.println("Dealt " + newCard.toString() + "\n");
        }
        System.out.println("Dealer hand value: " + hand.getValue());
        return hand.getValue();
    };
   
    public int scoreHand(Hand h){
        return h.getValue();
    };

    public void settleBets(){
        List<Player> players = table.getPlayers();
        
        Player winner = players.get(0);
       
        for (Player p:players){
            if(p.getHandTotal() > winner.getHandTotal())
            {
                winner = p;
            }
            else{
                p.settleBet(-p.getBet());
            } 
        }
        if( winner.getHandTotal() > hand.getValue()){
            winner.settleBet(table.getPot());
            System.out.println("\nPLAYER " + (players.indexOf(winner)+1) + " WINS " + table.getPot());
        }
    };
}
