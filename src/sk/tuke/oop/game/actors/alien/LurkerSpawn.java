/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.alien;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 *
 * @author jmorvay
 */
public class LurkerSpawn extends AbstractActor {
    public LurkerSpawn()
    {
        normalAnimation = new Animation("resources/sprites/lurker_born.png",32,32,100);
        normalAnimation.setLooping(false);
        setAnimation(normalAnimation);
    }     
    
}
