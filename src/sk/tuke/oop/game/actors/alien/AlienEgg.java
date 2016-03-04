/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.alien;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.Trigger;

/**
 *
 * @author jmorvay
 */
public class AlienEgg extends AbstractActor implements Observer{
    private int timer;
    private boolean spawn;    
    
    public AlienEgg(){
        normalAnimation = new Animation("resources/sprites/alien_egg.png",32,32,150);
        setAnimation(normalAnimation);  
        normalAnimation.setLooping(false);
        normalAnimation.stop();
    }      

    @Override
    public void giveNotice(Trigger trigger) {
        normalAnimation.start();
        spawn = true;
            
    }
    
public void act(){
        if(normalAnimation.getCurrentFrame() == 2){
            normalAnimation.stop();
        }    
}
    
}
