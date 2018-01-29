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
    
    static void basicGame(){
        List playerList = new ArrayList();
        Dealer dealer = new BlackjackDealer();
        for (int i = 0; i< 4;i++){
            playerList.add(new BasicPlayer());
        }
        BlackjackTable table = new BlackjackTable(playerList);
        System.out.println("Table set");
        dealer.takeBets();
        System.out.println("Bets taken");
        dealer.dealFirstCards();
        System.out.println("Cards dealt");
        //cycle through each player
        for(Object p: playerList){
            Player currentPlayer = (Player)p;
            System.out.println("Player " + (playerList.indexOf(p)+1) + "'s turn");
            System.out.println("Hand value: " + currentPlayer.getHandTotal());
            dealer.play(currentPlayer);
        }
        dealer.playDealer();
        System.out.println("Dealer has played");
        dealer.settleBets();
        System.out.println("Bets settles");
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
        Player player = new BasicPlayer();
        player.getHand().add(new Card(Card.Suit.CLUBS,Card.Rank.ACE));
        player.getHand().add(new Card(Card.Suit.CLUBS,Card.Rank.TWO));
        System.out.println(player.getHandTotal());
    }
    
}

