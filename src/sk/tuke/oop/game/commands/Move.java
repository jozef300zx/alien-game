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
public class Move implements Command{
    Movable actor;
    int step;
    int dx;
    int dy;
    
        public Move(Movable actor, int step, int dx, int dy)
        {
            this.actor = actor;
            this.step = step;
            this.dx = dx;
            this.dy = dy;
        }

    @Override
    public void Execute() {
        if(dx == 0 && dy == -1)
        {
        actor.setPosition(actor.getX(), actor.getY() - step);
            if (actor.getAnimation().getRotation() != 0)
            {
               actor.getAnimation().setRotation(0);
            }
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX(), actor.getY() + step);
        }
        }
        
        if(dx == 0 && dy == 1)
        {
        actor.setPosition(actor.getX(), actor.getY() + step);
            if (actor.getAnimation().getRotation() != 180)
            {
               actor.getAnimation().setRotation(180);
            }
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX(), actor.getY() - step);
        }            
        }
        
        if(dx == 1 && dy == 0)
        {
        actor.setPosition(actor.getX() + step, actor.getY());
            if (actor.getAnimation().getRotation() != 90)
            {
               actor.getAnimation().setRotation(90);
            }
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() - step, actor.getY());
        }            
        }
        
        if(dx == -1 && dy == 0)
        {
        actor.setPosition(actor.getX() - step, actor.getY());
            if (actor.getAnimation().getRotation() != 270)
            {
               actor.getAnimation().setRotation(270);
            }
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() + step, actor.getY());
        }            
        }
        
        if(dx == 1 && dy == 1)
        {
        actor.setPosition(actor.getX() + step, actor.getY() + step);
            if (actor.getAnimation().getRotation() != 135)
            {
               actor.getAnimation().setRotation(135);
            }
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() - step, actor.getY() - step);
        }            
        }
        
        if(dx == -1 && dy == 1)
        {
        actor.setPosition(actor.getX() - step, actor.getY() + step);
            if (actor.getAnimation().getRotation() != 225)
            {
               actor.getAnimation().setRotation(225);
            }
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() + step, actor.getY() - step);
        }            
        }        
        
        if(dx == -1 && dy == -1)
        {
        actor.setPosition(actor.getX() - step, actor.getY() - step);
            if (actor.getAnimation().getRotation() != 315)
            {
               actor.getAnimation().setRotation(315);
            }
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() + step, actor.getY() + step);
        }            
        }   
        if(dx == 1 && dy == -1)
        {
        actor.setPosition(actor.getX() + step, actor.getY() - step);
            if (actor.getAnimation().getRotation() != 45)
            {
               actor.getAnimation().setRotation(45);
            }
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() - step, actor.getY() + step);
        }            
        }
    actor.getAnimation().start();    
    }
    
}
