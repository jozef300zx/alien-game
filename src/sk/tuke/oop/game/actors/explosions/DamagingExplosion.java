/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.explosions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.AbstractCharacter;

/**
 *
 * @author jmorvay
 */
public class DamagingExplosion extends LargeExplosion{
    int damage;
    int countdown;    
    
    public DamagingExplosion(){
        super();
        countdown = 10;
        damage = 30;
    }
    
    public void act(){
        if(--countdown == 0){
            for(Actor actor : getWorld()){
            if(actor instanceof AbstractCharacter && this.intersects(actor))
            {
                ((AbstractCharacter)actor).setHealth(((AbstractCharacter)actor).getHealth() - damage);
            }
        }
        }
    }
    
}
