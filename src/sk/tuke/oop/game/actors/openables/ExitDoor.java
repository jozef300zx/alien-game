/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.game.actors.Usable;

/**
 *
 * @author jmorvay
 */
public class ExitDoor extends Door implements Usable {

    public ExitDoor(String name, boolean vertical) {
        super(name, vertical);
    }

    @Override
    public void use(Actor actor) {
        actor.getWorld().showMessage(new Message("Well Done!",100,10));
    }
    
}
