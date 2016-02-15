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
            moveNorth();
        }
        
        if(dx == 0 && dy == 1)
        {
            moveSouth();   
        }
        
        if(dx == 1 && dy == 0)
        {
            moveEast();
        }
        
        if(dx == -1 && dy == 0)
        {
            moveWest();  
        }
        
        if(dx == 1 && dy == 1)
        {
            moveSouthEast();
        }
        
        if(dx == -1 && dy == 1)
        {
            moveSouthWest();
        }        
        
        if(dx == -1 && dy == -1)
        {
            moveNorthWest();
        }   
        if(dx == 1 && dy == -1)
        {
            moveNorthEast();
        }
    actor.getAnimation().start();    
    }
 
    public void moveNorth(){
        actor.setPosition(actor.getX(), actor.getY() - step);
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX(), actor.getY() + step);
        } else {        
            if (actor.getAnimation().getRotation() != 0)
            {
               actor.getAnimation().setRotation(0);
            }
        }

    }
    
    public void moveSouth(){
        actor.setPosition(actor.getX(), actor.getY() + step);
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX(), actor.getY() - step);
        } else {        
            if (actor.getAnimation().getRotation() != 180)
            {
               actor.getAnimation().setRotation(180);
            }
        }

    }
    
    public void moveEast(){
        actor.setPosition(actor.getX() + step, actor.getY());
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() - step, actor.getY());
        } else {                
            if (actor.getAnimation().getRotation() != 90)
            {
               actor.getAnimation().setRotation(90);
            }
        }
   
    }
    
    public void moveWest(){
        actor.setPosition(actor.getX() - step, actor.getY());
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() + step, actor.getY());
        } else {        
            if (actor.getAnimation().getRotation() != 270)
            {
               actor.getAnimation().setRotation(270);
            }
        }

    }
    
    public void moveSouthEast(){
        actor.setPosition(actor.getX() + step, actor.getY() + step);
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() - step, actor.getY() - step);
            moveSouth();
            moveEast();
        } else {          
            if (actor.getAnimation().getRotation() != 135)
            {
               actor.getAnimation().setRotation(135);
            }
        }
         
    }
    
    public void moveSouthWest(){
        actor.setPosition(actor.getX() - step, actor.getY() + step);
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() + step, actor.getY() - step);
            moveSouth();
            moveWest();
        } else {         
            if (actor.getAnimation().getRotation() != 225)
            {
               actor.getAnimation().setRotation(225);
            }
        }
     
    }
    
    public void moveNorthWest(){
        actor.setPosition(actor.getX() - step, actor.getY() - step);
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() + step, actor.getY() + step);
            moveNorth();
            moveWest();
        } else {   
            if (actor.getAnimation().getRotation() != 315)
            {
               actor.getAnimation().setRotation(315);
            }
        }
                
    }
    
    public void moveNorthEast(){
        actor.setPosition(actor.getX() + step, actor.getY() - step);
        if(actor.getWorld().intersectWithWall(actor))
        {
            actor.setPosition(actor.getX() - step, actor.getY() + step);
            moveNorth();
            moveEast();
        } else {         
            if (actor.getAnimation().getRotation() != 45)
            {
               actor.getAnimation().setRotation(45);
            }
        }
      
    }
}
