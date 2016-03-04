/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.alien;

/**
 *
 * @author jmorvay
 */
public class Waiting implements AlienState{
    Alien alien;
    int movementInterval;
    double i;    
    
    public Waiting(Alien alien){
        this.alien = alien;
        movementInterval = 30;
        i = Math.random();   
    }

    @Override
    public void act() {
        alien.getAnimation().stop();
        alien.normalAnimation.stop();


        if(movementInterval == 0)
        {
             i = Math.random();
             movementInterval = 30;
        }
            if(i > 0 && i <= 0.06)
            {
                alien.getMoveUp().Execute();
            } 
            
            if (i > 0.06 && i <= 0.12)
            {
                alien.getMoveDown().Execute();
                
            } 
            
            if (i > 0.12 && i <= 0.18)
            {
                alien.getMoveRight().Execute();
                
            } 
            
            if (i > 0.18 && i <= 0.24)
            {
                alien.getMoveLeft().Execute();
            }
            
            if (i > 0.24 && i <= 0.3)
            {
                alien.getMoveDownRight().Execute();
            }
            if (i > 0.3 && i <= 0.36)
            {
                alien.getMoveDownLeft().Execute();
            }   
            if (i > 0.36 && i <= 0.42)
            {
                alien.getMoveUpRight().Execute();
            }            
            if (i > 0.42 && i <= 0.48)
            {
                alien.getMoveUpLeft().Execute();
            }            
            if (i > 0.48 && i <= 1)
            {
            }        
        movementInterval -=1;            
        alien.die();
    }
    
}
