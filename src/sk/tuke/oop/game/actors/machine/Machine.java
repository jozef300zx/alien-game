/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.machine;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 *
 * @author jmorvay
 */
public class Machine extends AbstractActor {
    AbstractMachineState state;
    
    public Machine(){
        normalAnimation = new Animation("resources/sprites/invisible.png",16,16,100);
        setAnimation(normalAnimation);
    }
    
public void floorSwitchActivated(){
    System.out.println("floorSwitchActivated");
}
 
public void wallSwitchActivated(){
    System.out.println("wallSwitchActivated");
}
 
public void leverRetracted(){
    System.out.println("leverRetracted");
}
 
public void act(){
}    
}
