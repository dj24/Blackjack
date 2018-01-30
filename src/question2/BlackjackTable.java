/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    
    static void basicGame(int games,int players){
        List playerList = new ArrayList();
        for (int j = 0; j< players;j++){
            playerList.add(new BasicPlayer());
        }
        for(int i = 0; i < games; i++){
            System.out.println("\n========================= NEW HAND #" + (i+1) + "=========================\n");
            
            BlackjackTable table = new BlackjackTable(playerList);

            Dealer dealer = new BlackjackDealer(table);

            dealer.takeBets();

            dealer.dealFirstCards();

            //cycle through each player
            for(Object p: playerList){
                Player currentPlayer = (Player)p;
                if(currentPlayer.getBalance() <= 0){
                    playerList.remove(p);
                    break;
                }
                System.out.println("\n------------------------- PLAYER " +
                        (playerList.indexOf(p)+1) +  " -------------------------\n");
                System.out.println("Current bet: £" + currentPlayer.getBet());
                System.out.println("Balance: £" + currentPlayer.getBalance());
                
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
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number of hands:");
        int hands = scan.nextInt();
        System.out.println("Enter Number of players:");
        int players = scan.nextInt();
        basicGame(hands,players);
    }
    
}

