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
public class BlackjackDealer implements Dealer{
    
    private Deck deck;
    private Hand hand;
    int pot;
    BlackjackTable table;
    
    BlackjackDealer(){
        this.table = new BlackjackTable();
        this.pot = 0;
        this.hand = new Hand();
        this.deck = new Deck();
    }
    
    public void assignPlayers(List<Player> p){
        table.addPlayers(p);
    };
    
    
    public void takeBets(){
        for(Player p : table.getPlayers()){
            pot += p.getBet();
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
        if(deck.size() < 52/4){
            deck.newDeck();
            deck.shuffle();
            p.newDeck();
        }
        boolean checkHit;
            do{
                //check if player wants to take card
                checkHit = p.hit();
                if(checkHit == true)
                    p.takeCard(deck.deal());
            }while(checkHit == true);
        return p.getHand().getValue();
    };

  
    public int playDealer(){
        while(hand.getValue() < 17){
            hand.add(deck.deal());
        }
        return hand.getValue();
    };
   
    public int scoreHand(Hand h){
        return h.getValue();
    };

    public void settleBets(){

    };
}
