/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

/**
 *
 * @author Daniel
 */
public class AdvancedPlayer extends IntermediatePlayer {

    
    @Override
    public int makeBet(){
        int cardCount = getCardCount();
        System.out.println("CARD COUNT = " + cardCount);
        if(cardCount >0){
            
            setBet(cardCount *10);
        }
        else{
            setBet(10);
        }
        System.out.println("BET: " + getBet());
        return getBet();
    }
}
