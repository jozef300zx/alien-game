/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.Movable;

/**
 *
 * @author admin
 */
public class MoveLeft implements Command{
        Movable actor;
int step;
    
    public MoveLeft(Movable actor, int step)
    {
      this.actor = actor;
      this.step = step;
    }
    
    @Override
    public void Execute() {
        actor.getAnimation().start();
        actor.setPosition(actor.getX() - step, actor.getY());
            if (actor.getAnimation().getRotation() != 270)
            {
               actor.getAnimation().setRotation(270);
            }   
    }
    
}
