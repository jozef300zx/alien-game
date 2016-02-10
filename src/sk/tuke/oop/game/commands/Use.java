/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.Usable;

/**
 *
 * @author admin
 */
public class Use implements Command {
    Usable actor;
    Actor actuator;
    
    public Use(Actor actor, Actor actuator)
    {
        this.actor = (Usable) actor;
        this.actuator = actuator;
    }

    @Override
    public void Execute() {
        actor.use(actuator);
    }
}
