/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class BlackjackTable {
    private List<Player> players;
    private Dealer dealer;
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
    
}
