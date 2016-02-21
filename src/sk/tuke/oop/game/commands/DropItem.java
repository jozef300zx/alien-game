/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author admin
 */
public class DropItem implements Command {
    BackpackImpl backpack;
    World world;
    int x,y;
    
    public DropItem(BackpackImpl backpack, World world, int x, int y)
    {
        this.backpack = backpack;
        this.world = world;
        this.x = x;
        this.y = y;
    }

    @Override
    public void Execute() {
        
        this.world.addActor(backpack.getLastItem());
        this.backpack.getLastItem().setPosition(x, y);
        boolean intersects;
        
        
        do 
        {
        intersects = false;
        for(Actor actor : world)
        {
            if((this.backpack.getLastItem().intersects(actor) || this.backpack.getLastItem().getWorld().intersectWithWall(this.backpack.getLastItem()))&& this.backpack.getLastItem() != actor && !(actor instanceof Ripley))
            {
                this.backpack.getLastItem().setPosition(this.backpack.getLastItem().getX() + this.backpack.getLastItem().getWidth() + 1, this.backpack.getLastItem().getY());
                intersects = true;
            }
        }
        } while(intersects);
        
        
        this.backpack.remove(backpack.getLastItem());
        
        
    }
    
}
