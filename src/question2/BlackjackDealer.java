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
    
    private Deck deck = new Deck();
    private Hand hand;
    int pot = 0;
    BlackjackTable table;
    
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
        return p.getHand().getValue();
    };

  
    public int playDealer(){
        return 0;
    };
   
    public int scoreHand(Hand h){
        return h.getValue();
    };

    public void settleBets(){

    };
}
