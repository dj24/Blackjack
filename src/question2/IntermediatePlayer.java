/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.List;
import question1.*;

/**
 *
 * @author User
 */
public class IntermediatePlayer extends BasicPlayer{
   
    private int BET;
    
    public boolean hit(){

        int soft = getHand().getSoftValue();
        int normal = getHand().getValue();
        int dealer = getDealerCard().getValue();
        //System.out.println(dealerCard);
        if(isBust()){
            System.out.println("BUST");
            return false;
        }
        else if(normal == 11 && (soft == 9 || soft ==10)){
            System.out.println("STICK");
            return false;
        }
        else if(soft <= 8){
            System.out.println("HIT");
            return true;
        }
        else if(dealer >= 7){
            if(normal < 17){
                System.out.println("HIT");
                return true;
            }
        }
        else if(dealer <= 6){
            if(normal < 12){
                System.out.println("HIT");
                return true;
            }
        }
        
        System.out.println("STICK");
        return false;
    };
    
    

    
}
