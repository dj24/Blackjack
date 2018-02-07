
package question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import question1.*;

/**
 *Daniel Jackson
 */
public class BlackjackTable {
    private List<Player> players;
    public static final int MAX_PLAYERS = 8;
    public static final int MIN_BET = 1;
    public static final int MAX_BET = 500;
    
    public BlackjackTable(){
        players = new ArrayList();
    }
    
    static void gameControl(String game){
        ArrayList playerList = new ArrayList();
        System.out.println("Enter number of hands to play:");
        int hands = new Scanner(System.in).nextInt();
        
        switch(game){
            case "b":
                for (int j = 0; j< 4;j++){
                    playerList.add(new BasicPlayer());
                }
                Game(hands,playerList);
                break;
            case "i":
                for (int j = 0; j< 4;j++){
                    playerList.add(new IntermediatePlayer());
                }
                Game(hands,playerList);
                break;
            case "h":
                humanGame(hands);
                break;
            case "a":
                playerList.add(new BasicPlayer());
                playerList.add(new IntermediatePlayer());
                playerList.add(new AdvancedPlayer());
                Game(hands,playerList);
                break;
            default:
                break;
            
        }
        
    }
    
    static void Game(int hands,ArrayList<Player> playerList){
        
        BlackjackTable table = new BlackjackTable();
        Dealer dealer = new BlackjackDealer(table);
        dealer.assignPlayers(playerList);
        Scanner scan = new Scanner(System.in);
        int count = 0;
        
        System.out.println("Enter number of hands to step through:");
        int steps = scan.nextInt();
        
        while(steps > hands){
        System.out.print("Too many steps for number of hands selected. "
                + "Please try again: ");
                steps = scan.nextInt(); 
        }
  
        while(count < hands && !playerList.isEmpty()){
            System.out.println("------- HAND #" + (count+1) + "------");
            dealer.takeBets();
            dealer.dealFirstCards();
            for(Object p: playerList){
                System.out.println("----- PLAYER " + (playerList.indexOf(p)+1)
                        + "'S ("
                        + (p.getClass()) + ") TURN -----");
                Player currentPlayer = (Player)p;
                System.out.println("Balance: " + currentPlayer.getBalance());
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
            count++;
            System.out.println("LOOP COUNT = " + count);
            if(playerList.isEmpty()){
                System.out.println("All players have run out of money");
            }
        }                
    }
    
    static void humanGame(int games){
        Player p = new HumanPlayer();
        Player b = new BasicPlayer();
        List<Player> playerList = new ArrayList();
        playerList.add(p);
        playerList.add(b);
        BlackjackTable table = new BlackjackTable();
        Dealer dealer = new BlackjackDealer(table);
        dealer.assignPlayers(playerList);
        
        for(int i = 0; i < games; i++){
            System.out.println("------- HAND #" + (i+1) + "------");
            System.out.println("Balance: £" + p.getBalance());
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
            
            System.out.println("----- BASIC PLAYER'S TURN -----");
            Player currentPlayer = (Player)p;
            System.out.println("Balance: " + currentPlayer.getBalance());
            System.out.println(currentPlayer.getHand().toString());
            if(currentPlayer.getBalance() <= 0){
                System.out.println("Player out of funds, removed from game\n");
                playerList.remove(b);
            }
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
    


