/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;

/**
 *
 * @author admin
 */
public class Energy extends AbstractActor implements Item {
 
    public Energy()
    {
        normalAnimation = new Animation("resources/sprites/energy.png",16,16,100);
        setAnimation(normalAnimation);
    }
}
