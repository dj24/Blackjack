/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.Scanner;
import question1.*;

/**
 *
 * @author User
 */
public class HumanPlayer extends BasicPlayer{
    
    

    
    public int makeBet(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter bet amount:");
        int input = scan.nextInt();
        setBet(getBet()+input);
        return getBet();
    };
    
    public boolean hit(){
        if(blackjack()){
            System.out.println("BLACKJACK");
            return false;
        }
        if(getHandTotal() == 21){
            return false;
        }
        if(!isBust()){
            System.out.println("Stick(s) or Hit(h)?");
            return("h".equals(new Scanner(System.in).next()));
        }
        else{
            System.out.println("Went bust\n");
            return false;
        }
        
    }
}
