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
public class MoveDown implements Command{
    Movable actor;
int step;
    
    public MoveDown(Movable actor, int step)
    {
      this.actor = actor;
      this.step = step;
    }
    
    @Override
    public void Execute() {
        actor.getAnimation().start();
        actor.setPosition(actor.getX(), actor.getY() + step);
            if (actor.getAnimation().getRotation() != 180)
            {
               actor.getAnimation().setRotation(180);
            }

        
    }

    
}
