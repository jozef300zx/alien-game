/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author admin
 */
public class DropItem implements Command {
    BackpackImpl backpack;
    World world;
    Actor owner;
    int x,y;
    
    public DropItem(BackpackImpl backpack, World world, int x, int y)
    {
        this.backpack = backpack;
        this.x = x;
        this.y = y;
        this.world = world;
    }

    @Override
    public void Execute() {
        
        /*
        do 
        {
        intersects = false;   
        
        if(owner.getWorld().isWall((this.x)/16,(this.y)/16) || 
           owner.getWorld().isWall((this.x + backpack.getLastItem().getWidth())/16,(this.y)/16) ||
           owner.getWorld().isWall((this.x)/16,(this.y + backpack.getLastItem().getHeight())/16) ||
           owner.getWorld().isWall((this.x + backpack.getLastItem().getWidth())/16,(this.y + backpack.getLastItem().getHeight())/16)){
            
            intersects = true;
            
            if(owner.getY() >= y && owner.getX() + owner.getWidth() > x){
                x = x + backpack.getLastItem().getWidth() + 1;
            } else {
                if(owner.getX() + owner.getWidth() <= x && owner.getY() + owner.getHeight() > y){
                    y = y + backpack.getLastItem().getHeight() + 1;
                } else {
                    if(owner.getY() + owner.getHeight() >= y && owner.getX() < x + backpack.getLastItem().getWidth()){
                        x = x - (backpack.getLastItem().getWidth() +1);
                    } else {
                        if(owner.getX() <= x + backpack.getLastItem().getWidth() && owner.getY() < y + backpack.getLastItem().getHeight()){
                            y = y - (backpack.getLastItem().getHeight() + 1);
                        }
                    }
                }
            }   
        } else {
            this.owner.getWorld().addActor(backpack.getLastItem());
            this.backpack.getLastItem().setPosition(x, y);
            this.backpack.remove(backpack.getLastItem());
        }
        } while(intersects);
        */
        
        this.world.addActor(backpack.getLastItem());
        this.backpack.getLastItem().setPosition(x, y);
        boolean intersects;
        
        
        do 
        {
        intersects = false;
        for(Actor actor : world)
        {
            if(this.backpack.getLastItem().intersects(actor)&& this.backpack.getLastItem() != actor && actor instanceof Item)
            {
                this.backpack.getLastItem().setPosition(this.backpack.getLastItem().getX() + this.backpack.getLastItem().getWidth() + 1, this.backpack.getLastItem().getY());
                intersects = true;
            }
        }
        } while(intersects);
        
        
        this.backpack.remove(backpack.getLastItem());
        
        
    }
    
}
