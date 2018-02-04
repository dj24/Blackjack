/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import question1.*;

/**
 *
 * @author User
 */
public class IntermediatePlayer extends BasicPlayer{
    private Hand hand;
    private int balance;
    private final int BET = 10;
    private Card dealerCard;
    
    public boolean hit(){
        int soft = 1;
        int normal = 1;
        int dealer = 1;
        //System.out.println(dealerCard);
        if(soft == 9 || soft == 10)
            return false;
        else if(soft <= 8)
            return true;
        else if(dealer >= 7){
            if(normal < 17)
                return true;
        }
        else if(dealer != 11){
            if(normal < 12)
                return true;
        }
        return false;
    };
}
