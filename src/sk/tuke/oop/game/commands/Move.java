/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.Projectile;

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
       
    }
 
    public void moveNorth(){
        actor.setPosition(actor.getX(), actor.getY() - step);
        if(actor.getWorld().intersectWithWall(actor) && !(actor instanceof Projectile))
        {
            actor.setPosition(actor.getX(), actor.getY() + step);
        } else {        
            turnAnimation(0);
        }
    }
    
    public void moveSouth(){
        actor.setPosition(actor.getX(), actor.getY() + step);
        if(actor.getWorld().intersectWithWall(actor) && !(actor instanceof Projectile))
        {
            actor.setPosition(actor.getX(), actor.getY() - step);
        } else {        
            turnAnimation(180);
        }
    }
    
    public void moveEast(){
        actor.setPosition(actor.getX() + step, actor.getY());
        if(actor.getWorld().intersectWithWall(actor) && !(actor instanceof Projectile))
        {
            actor.setPosition(actor.getX() - step, actor.getY());
        } else {                
            turnAnimation(90);
        }
   
    }
    
    public void moveWest(){
        actor.setPosition(actor.getX() - step, actor.getY());
        if(actor.getWorld().intersectWithWall(actor) && !(actor instanceof Projectile))
        {
            actor.setPosition(actor.getX() + step, actor.getY());
        } else {        
            turnAnimation(270);
        }
    }
    
    public void moveSouthEast(){
        actor.setPosition(actor.getX() + step, actor.getY() + step);
        if(actor.getWorld().intersectWithWall(actor) && !(actor instanceof Projectile))
        {
            actor.setPosition(actor.getX() - step, actor.getY() - step);
            moveSouth();
            moveEast();
        } else {          
            turnAnimation(135);
        }
         
    }
    
    public void moveSouthWest(){
        actor.setPosition(actor.getX() - step, actor.getY() + step);
        if(actor.getWorld().intersectWithWall(actor) && !(actor instanceof Projectile))
        {
            actor.setPosition(actor.getX() + step, actor.getY() - step);
            moveSouth();
            moveWest();
        } else {         
            turnAnimation(225);
        }
     
    }
    
    public void moveNorthWest(){
        actor.setPosition(actor.getX() - step, actor.getY() - step);
        if(actor.getWorld().intersectWithWall(actor) && !(actor instanceof Projectile))
        {
            actor.setPosition(actor.getX() + step, actor.getY() + step);
            moveNorth();
            moveWest();
        } else {   
            turnAnimation(315);
        }
                
    }
    
    public void moveNorthEast(){
        actor.setPosition(actor.getX() + step, actor.getY() - step);
        if(actor.getWorld().intersectWithWall(actor) && !(actor instanceof Projectile))
        {
            actor.setPosition(actor.getX() - step, actor.getY() + step);
            moveNorth();
            moveEast();
        } else {         
            turnAnimation(45);
        }
      
    }
    
    public void turnAnimation(int angle){
            if (actor.getAnimation().getRotation() != angle)
            {
               actor.getAnimation().setRotation(angle);
            }
            
            actor.getAnimation().start(); 
    }
}
