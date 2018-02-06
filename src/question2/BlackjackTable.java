/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
    public int pot = 0;
    
    public BlackjackTable(){
        players = new ArrayList();
    }
    
    static void gameControl(String game){
        System.out.println("Enter number of games to play:");
        int games = new Scanner(System.in).nextInt();
        
        switch(game){
            case "b":
                Game(games,createPlayers("basic"));
                break;
            case "i":
                Game(games,createPlayers("intermediate"));
                break;
            case "h":
                humanGame(games);
                break;
            case "a":
                Game(games,createPlayers("advanced"));
                break;
            default:
                break;
            
        }
        
    }
    static ArrayList<Player> createPlayers(String game){
    ArrayList playerList = new ArrayList();
        
        switch(game){
            case "basic":
                for (int j = 0; j< 4;j++){
                    playerList.add(new BasicPlayer());
                }
                break;
            case"intermediate":
                for (int j = 0; j< 4;j++){
                    playerList.add(new IntermediatePlayer());
                }
                break;
            case "advanced":
                playerList.add(new BasicPlayer());
                playerList.add(new IntermediatePlayer());
                playerList.add(new AdvancedPlayer());
                break;
        }
        return playerList;
    }
    
    static void Game(int games,ArrayList<Player> playerList){
        BlackjackTable table = new BlackjackTable();
        Dealer dealer = new BlackjackDealer(table);
        dealer.assignPlayers(playerList);
        
        for(int i = 0; i < games; i++){
           
            dealer.takeBets();
            dealer.dealFirstCards();
            for(Object p: playerList){
                System.out.println("----- PLAYER " + (playerList.indexOf(p)+1)
                        + "'S ("
                        + (p.getClass()) + ") TURN -----");
                Player currentPlayer = (Player)p;
                System.out.println(currentPlayer.getHand().toString());
                if(currentPlayer.getBalance() <= 0){
                    System.out.println("Player out of funds, removed from game\n");
                    playerList.remove(p);
                    break;
                }
                dealer.play(currentPlayer);
            }
            System.out.println("------ DEALER'S TURN ------");
            dealer.playDealer();
            System.out.println("------- HAND SUMMARY ------");
            dealer.settleBets();
        }
        for(Object p: playerList){
            Player currentPlayer = (Player)p;
            System.out.print("Player " + (playerList.indexOf(p)+1) + " balance: ");
            System.out.print(currentPlayer.getBalance() + "\n");
        }
    }
    
    static void humanGame(int games){
        Player p = new HumanPlayer();
        List<Player> playerList = Collections.singletonList(p);
        
        BlackjackTable table = new BlackjackTable();
        Dealer dealer = new BlackjackDealer(table);
        dealer.assignPlayers(playerList);
        
        for(int i = 0; i < games; i++){
            dealer.takeBets();
            dealer.dealFirstCards();

            if(p.getBalance() <= 0){
                System.out.println("BUST");
            }

            System.out.println("Balance: £" + p.getBalance());
            System.out.println("Current bet: £" + p.getBet());
            System.out.println("Players hand:");
            System.out.println(p.getHand().toString());

            dealer.play(p);
            System.out.println("------ DEALER'S TURN ------");
            dealer.playDealer();
            System.out.println("------- HAND SUMMARY ------");
            dealer.settleBets();
        }
    }
    
    public void addPlayers(List<Player> newPlayers){
        for(Player p : newPlayers){
            players.add(p);
        }
    }
    
    public List<Player> getPlayers(){
        return players;
    }
    
    public static void main(String[] args) {
        while(true){
            System.out.println("\n======================= SELECT GAME " 
                    + " =======================\n"
                    + "-Basic(b)\n-Intermediate(i)\n-Human(h)\n"
                    + "-Advanced(a)\n");
            gameControl(new Scanner(System.in).next());
        }
    }
        
}
    


