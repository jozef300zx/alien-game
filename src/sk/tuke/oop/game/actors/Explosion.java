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
    private boolean addedToWorld;
    private boolean exploding;
    
        public Explosion(){
        normalAnimation = new Animation("resources/sprites/small_explosion.png",16,16,100);
        setAnimation(normalAnimation);
        timer = 100;
        addedToWorld = false;
       
    }  
    
        public void explode(){
            normalAnimation.start();
            setExploding(true);
        }

    /**
     * @return the timer
     */
    public int getTimer() {
        return timer;
    }

    /**
     * @return the addedToWorld
     */
    public boolean isAddedToWorld() {
        return addedToWorld;
    }

    /**
     * @param addedToWorld the addedToWorld to set
     */
    public void setAddedToWorld(boolean addedToWorld) {
        this.addedToWorld = addedToWorld;
    }

    /**
     * @return the exploding
     */
    public boolean isExploding() {
        return exploding;
    }

    /**
     * @param exploding the exploding to set
     */
    public void setExploding(boolean exploding) {
        this.exploding = exploding;
    }

    /**
     * @param timer the timer to set
     */
    public void setTimer(int timer) {
        this.timer = timer;
    }
}
