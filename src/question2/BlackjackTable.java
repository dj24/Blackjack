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
    public int pot = 0;
    
    public BlackjackTable(){
        players = new ArrayList();
    }
    
     public BlackjackTable(Player player){
        players = new ArrayList();
        players.add(player);
    }
     
    public BlackjackTable(List<Player> newPlayers){
        players = new ArrayList();
        for(Player p : newPlayers){
            players.add(p);
        }
    }
    static void gameControl(String game){
        System.out.println("Enter number of games to play:");
        int games = new Scanner(System.in).nextInt();
        
        switch(game){
            case "b":
                basicGame(games,4);
                break;
            case "i":
                //intermediateGame();
                break;
            case "h":
                humanGame();
            case "a":
                //advancedGame();
                break;
            default:
                break;
            
        }
        
    }
    static void basicGame(int games,int players){
        List playerList = new ArrayList();
        for (int j = 0; j< players;j++){
            playerList.add(new BasicPlayer());
        }
        for(int i = 0; i < games; i++){
            BlackjackTable table = new BlackjackTable(playerList);
            Dealer dealer = new BlackjackDealer(table);
            dealer.takeBets();
            dealer.dealFirstCards();
            for(Object p: playerList){
                Player currentPlayer = (Player)p;
                if(currentPlayer.getBalance() <= 0){
                    playerList.remove(p);
                    break;
                }
                dealer.play(currentPlayer);
            }
            dealer.playDealer();
            dealer.settleBets();
        }
        for(Object p: playerList){
            Player currentPlayer = (Player)p;
            System.out.print("Player " + (playerList.indexOf(p)+1) + " balance: ");
            System.out.print(currentPlayer.getBalance() + "\n");
        }
    }
    
    static void intermediateGame(int games,int players){
        List playerList = new ArrayList();
        for (int j = 0; j< players;j++){
            playerList.add(new IntermediatePlayer());
        }
        for(int i = 0; i < games; i++){
            BlackjackTable table = new BlackjackTable(playerList);
            Dealer dealer = new BlackjackDealer(table);
            dealer.takeBets();
            dealer.dealFirstCards();
            for(Object p: playerList){
                Player currentPlayer = (Player)p;
                if(currentPlayer.getBalance() <= 0){
                    playerList.remove(p);
                    break;
                }
                dealer.play(currentPlayer);
            }
            dealer.playDealer();
            dealer.settleBets();
        }
        for(Object p: playerList){
            Player currentPlayer = (Player)p;
            System.out.print("Player " + (playerList.indexOf(p)+1) + " balance: ");
            System.out.print(currentPlayer.getBalance() + "\n");
        }
    }
    
    static void humanGame(){
        Player p = new HumanPlayer();

        BlackjackTable table = new BlackjackTable(p);

        Dealer dealer = new BlackjackDealer(table);

        dealer.takeBets();

        dealer.dealFirstCards();

        if(p.getBalance() <= 0){
            System.out.println("bust");
        }

        System.out.println("Balance: £" + p.getBalance());
        System.out.println("Current bet: £" + p.getBet());
        System.out.println("\nPlayers hand:");
        System.out.println(p.getHand().toString());

        dealer.play(p);

        System.out.println("Hand value: " + p.getHandTotal());
        dealer.playDealer();
        dealer.settleBets();
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
        while(true){
            System.out.println("\n======================= SELECT GAME " 
                    + " =======================\n"
                    + "-Basic(b)\n-Intermediate(i)\n-Human(h)\n"
                    + "-Advanced(a)\n");
            gameControl(new Scanner(System.in).next());
        }
    }
        
}
    


