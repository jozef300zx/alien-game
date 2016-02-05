/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.World;

/**
 *
 * @author admin
 */
public class Ripley implements Actor {
    int x;
    int y;
    int height;
    int width;
    int step;
    String name;
    String direction;
    Animation normalAnimation;
    Input input;
    
    Ripley()
    {
        normalAnimation = new Animation("resources/sprites/player.png",32,32,100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        step = 2;
        
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setPosition(int i, int i1) {
        this.x = i;
        this.y = i1;
    }

    @Override
    public Animation getAnimation() {
        return this.normalAnimation;
    }

    @Override
    public void setAnimation(Animation anmtn) {
        this.normalAnimation = anmtn;
    }

    @Override
    public void act() {
        input = Input.getInstance();
        normalAnimation.stop();
        
        if(input.isKeyPressed(Input.Key.ESCAPE))
        {
            System.exit(0);
        }
        
        if(input.isKeyDown(Input.Key.UP))
        {
            normalAnimation.start();
            this.setPosition(this.getX(), this.getY() - step);
            
            if (direction != "up")
            {
               normalAnimation.setRotation(0);
               direction = "up";
            }
        }
        
        if(input.isKeyDown(Input.Key.DOWN))
        {
            normalAnimation.start();
            this.setPosition(this.getX(), this.getY() + step);
            
            if (direction != "down")
            {
               normalAnimation.setRotation(180);
               direction = "down";
            }
        }
        
        if(input.isKeyDown(Input.Key.RIGHT))
        {
            normalAnimation.start();
            this.setPosition(this.getX() + step, this.getY());
            
            if (direction != "right")
            {
               normalAnimation.setRotation(90);
               direction = "right";
            }
        }
        
        if(input.isKeyDown(Input.Key.LEFT))
        {
            normalAnimation.start();
            this.setPosition(this.getX() - step, this.getY());
            
            if (direction != "left")
            {
               normalAnimation.setRotation(270);
               direction = "left";
            }
        }
        
        
        
    }

    @Override
    public boolean intersects(Actor actor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addedToWorld(World world) {
        
    }

    @Override
    public World getWorld() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return this.name;
    }
    
}
