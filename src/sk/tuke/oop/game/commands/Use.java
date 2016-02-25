/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.openables.Openable;
import sk.tuke.oop.game.actors.Usable;

/**
 *
 * @author admin
 */
public class Use implements Command {
    Actor actor;
    Actor actuator;
    
    public Use(Actor actor, Actor actuator)
    {
        this.actor = actor;
        this.actuator = actuator;
    }

    @Override
    public void Execute() {
        if(actor instanceof Usable){
        ((Usable) actor).use(actuator);
        }
               
        if(actor instanceof Openable){
            
            if(!((Openable) actor).isOpen(actor)){
                ((Openable) actor).open();
            } else {
                ((Openable) actor).close();
            }
            
        }
        
        
        
    }

    
}
