/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

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
        this.backpack.remove(backpack.getLastItem());   
    }
    
}
