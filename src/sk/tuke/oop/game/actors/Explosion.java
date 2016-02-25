/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class Explosion extends AbstractActor{
    private int timer;
    
        public Explosion(){
        normalAnimation = new Animation("resources/sprites/small_explosion.png",16,16,100);
        setAnimation(normalAnimation);
        timer = 100;
       
    }  
    
        public void explode(){
            normalAnimation.start();
        }

    /**
     * @return the timer
     */
    public int getTimer() {
        return timer;
    }

  

    /**
     * @param timer the timer to set
     */
    public void setTimer(int timer) {
        this.timer = timer;
    }
}
