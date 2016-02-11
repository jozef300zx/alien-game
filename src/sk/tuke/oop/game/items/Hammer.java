/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 *
 * @author admin
 */
public class Hammer extends AbstractActor implements Item{
    
    public Hammer()
    {
        normalAnimation = new Animation("resources/sprites/hammer.png",16,16,100);
        setAnimation(normalAnimation);
    }
    
}
