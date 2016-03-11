/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.tiles;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author jmorvay
 */
public class InvisibleTile17x12 extends InvisibleTile{
    private int timer;
    
    public InvisibleTile17x12(){
        normalAnimation = new Animation("resources/sprites/invisible.png",432,192,100);
        setAnimation(normalAnimation);    
    }     
    
    public void act(){
        if(this.ripley == null){
        for(Actor actor : getWorld()){
            if(actor instanceof Ripley ){
                this.ripley = actor;
            }
        }
        }
        
        if(this.intersects(ripley) && ++timer % 60 == 0){
            ((AbstractCharacter)ripley).setHealth(((AbstractCharacter)ripley).getHealth() - 5);
        }
        
        if(timer == Integer.MAX_VALUE){
            timer = 0;
        }
    }
    
}
