/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.alien;

import sk.tuke.oop.game.actors.alien.Alien;
import sk.tuke.oop.game.actors.alien.AlienState;

/**
 *
 * @author jmorvay
 */
public class Waiting implements AlienState{
    Alien alien;
    
    public Waiting(Alien alien){
        this.alien = alien;
    }

    @Override
    public void act() {
        alien.getAnimation().stop();
        alien.die();
    }
    
}
