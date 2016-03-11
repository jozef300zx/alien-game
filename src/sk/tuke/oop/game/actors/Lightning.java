/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.alien.Enemy;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author jmorvay
 */
public class Lightning extends AbstractActor implements Expirable{
    private int timer;
    
    public Lightning()
    {
        normalAnimation = new Animation("resources/sprites/electricity.png",16,48,100);
        setAnimation(normalAnimation);
        normalAnimation.start();
        timer = 50;
    }        

    @Override
    public int getTimer() {
        return this.timer;
    }

    @Override
    public void setTimer(int i) {
        this.timer = i;
    }
    
    public void  act(){
        for(Actor actor : getWorld()){
            if((actor instanceof Ripley || actor instanceof Enemy) && this.intersects(actor) && getTimer() % 3 == 0){
                ((AbstractCharacter) actor).setHealth(((AbstractCharacter) actor).getHealth() - 1);
            }
        }
    }
    
}
