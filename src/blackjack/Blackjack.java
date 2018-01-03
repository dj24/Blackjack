/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
 

public class Blackjack {

    
    public static void main(String[] args) {
        
        Card.Rank rank = Card.Rank.THREE;
        
        System.out.println(rank.getPrevious());
    }
    
}
