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
public class BlackjackTable {
    private List<Player> players;
    public static final int MAX_PLAYERS = 8;
    public static final int MIN_BET = 1;
    public static final int MAX_BET = 500;
    
    public BlackjackTable(){
        players = new ArrayList();
    }
    
    public BlackjackTable(List<Player> newPlayers){
        players = new ArrayList();
        for(Player p : newPlayers){
            players.add(p);
        }
    }
    
    static void basicGame(int games){
        for(int i = 0; i < games; i++){
            System.out.println("\n========================= NEW HAND =========================\n");
            List playerList = new ArrayList();

            for (int j = 0; j< 4;j++){
                playerList.add(new BasicPlayer());
            }
            BlackjackTable table = new BlackjackTable(playerList);

            Dealer dealer = new BlackjackDealer(table);

            dealer.takeBets();

            dealer.dealFirstCards();

            //cycle through each player
            for(Object p: playerList){
                Player currentPlayer = (Player)p;
                
                System.out.println("\n------------------------- PLAYER " +
                        (playerList.indexOf(p)+1) +  " -------------------------\n");
                System.out.println("Balance: £" + currentPlayer.getBalance() + 
                        " - £" + currentPlayer.getBet());
                
                System.out.println("\nPlayers hand:");
                System.out.println(currentPlayer.getHand().toString());

                dealer.play(currentPlayer);
                
                System.out.println("Hand value: " + currentPlayer.getHandTotal());


            }
            dealer.playDealer();
            dealer.settleBets();
        }
    }
    
    public void addPlayers(List<Player> newPlayers){
        for(Player p : newPlayers){
            players.add(p);
        }
    }
    
    public void addPlayers(Player p){
        players.add(p);
    }
    
    public List<Player> getPlayers(){
        return players;
    }
    
    public static void main(String[] args) {
        /*
        Player player = new BasicPlayer();
        Dealer dealer = new BlackjackDealer();
        Deck deck = new Deck();
        deck.shuffle();
        player.takeCard(deck.deal());
        //player.takeCard(new Card(Card.Suit.CLUBS,Card.Rank.TWO));
        System.out.println(player.getHandTotal());
        */
        //basicGame(4);
        
        Hand hand = new Hand();
        hand.add(new Card(Card.Suit.CLUBS,Card.Rank.FIVE));
        hand.add(new Card(Card.Suit.CLUBS,Card.Rank.FIVE));
        hand.add(new Card(Card.Suit.CLUBS,Card.Rank.ACE));
        System.out.println(hand.getValue());
    }
    
}

