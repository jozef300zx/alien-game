/*
 * To change alien license header, choose License Headers in Project Properties.
 * To change alien template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.alien;

/**
 *
 * @author jmorvay
 */
public class Active implements AlienState {
    int movementInterval;
    double i;
    
    Alien alien;
    
    public Active(Alien alien){
        this.alien = alien;
        movementInterval = 30;
        i = Math.random();        
    }

    @Override
    public void act() {
        alien.normalAnimation.stop();
        
            if(alien.getX() == alien.getRipley().getX() && alien.getY() > alien.getRipley().getY())
            {
                alien.getMoveUp().Execute();
            } 
            
            if (alien.getX() == alien.getRipley().getX() && alien.getY() < alien.getRipley().getY())
            {
                alien.getMoveDown().Execute();
            } 
            
            if (alien.getX() < alien.getRipley().getX() && alien.getY() == alien.getRipley().getY())
            {
                alien.getMoveRight().Execute();
            } 
            
            if (alien.getX() > alien.getRipley().getX() && alien.getY() == alien.getRipley().getY())
            {
                alien.getMoveLeft().Execute();
            }
            
            if (alien.getX() < alien.getRipley().getX() && alien.getY() < alien.getRipley().getY())
            {
                alien.getMoveDownRight().Execute();
            }
            if (alien.getX() > alien.getRipley().getX() && alien.getY() < alien.getRipley().getY())
            {
                alien.getMoveDownLeft().Execute();
            }   
            if (alien.getX() < alien.getRipley().getX() && alien.getY() > alien.getRipley().getY())
            {
                alien.getMoveUpRight().Execute();
            }            
            if (alien.getX() > alien.getRipley().getX() && alien.getY() > alien.getRipley().getY())
            {
                alien.getMoveUpLeft().Execute();
            }
        
        
        if(alien.intersects(alien.getRipley()))
        {
            alien.getRipley().setHealth(alien.getRipley().getHealth() - 1);
        }
        
        alien.die();
    }


    
}
