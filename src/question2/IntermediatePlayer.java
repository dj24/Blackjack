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
    
    public boolean hit(){
        if(hand.getValue() < 17){
            return true;
        }
        return false;
    };
}
