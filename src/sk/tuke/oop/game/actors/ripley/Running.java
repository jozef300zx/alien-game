/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.ripley;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.game.actors.BrokenCooler;
import sk.tuke.oop.game.actors.BrokenFan;
import sk.tuke.oop.game.actors.Explosion;
import sk.tuke.oop.game.actors.SmallExplosion;
import sk.tuke.oop.game.actors.Usable;
import sk.tuke.oop.game.actors.machine.FloorSwitch;
import sk.tuke.oop.game.actors.machine.Lever;
import sk.tuke.oop.game.actors.machine.Machine;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.game.commands.NextItem;
import sk.tuke.oop.game.commands.TakeItem;
import sk.tuke.oop.game.commands.Use;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author jmorvay
 */
public class Running implements RipleyState{
    Ripley ripley;
    Move moveUp;
    Move moveDown;
    Move moveRight;
    Move moveLeft;
    Move moveDownRight;
    Move moveDownLeft;
    Move moveUpRight;
    Move moveUpLeft;
    TakeItem takeItem;
    DropItem dropItem;
    NextItem nextItem;
    Machine machine;

    
    public Running(Ripley ripley){
                this.ripley = ripley;
                this.ripley.setName("ripley");

    }

    @Override
    public void act() {
        ripley.normalAnimation.stop();
        //Message abcd = new Message("ABCD",100,300);
        List<Actor> toRemove = new ArrayList<> ();
        ripley.setInput(Input.getInstance());
        ripley.getWorld().showMessage(new Message("Health: " + ripley.getHealth() + " | Ammo: " + ripley.getAmmo() + " | Energy pulse: " + ripley.getPulse(),100,10));
        //ripley.getWorld().showMessage(abcd);

        //inicializacia
        if (moveUp == null) {
            moveUp = new Move(ripley, 2, 0, -1);
        }
        if (moveDown == null) {
            moveDown = new Move(ripley, 2, 0, 1);
        }
        if (moveRight == null) {
            moveRight = new Move(ripley, 2, 1, 0);
        }
        if (moveLeft == null) {
            moveLeft = new Move(ripley, 2, -1, 0);
        }
        if (moveDownRight == null) {
            moveDownRight = new Move(ripley, 2, 1, 1);
        }
        if (moveDownLeft == null) {
            moveDownLeft = new Move(ripley, 2, -1, 1);
        }
        if (moveUpRight == null) {
            moveUpRight = new Move(ripley, 2, 1, -1);
        }
        if (moveUpLeft == null) {
            moveUpLeft = new Move(ripley, 2, -1, -1);
        }
        
        
        //pohyby
        if (ripley.getInput().isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }
        
        
        
        if (ripley.getInput().isKeyDown(Input.Key.UP) == false && ripley.getInput().isKeyDown(Input.Key.DOWN) && ripley.getInput().isKeyDown(Input.Key.RIGHT) && ripley.getInput().isKeyDown(Input.Key.LEFT) == false) {
            moveDownRight.Execute();
        }
        if (ripley.getInput().isKeyDown(Input.Key.UP) == false && ripley.getInput().isKeyDown(Input.Key.DOWN) && ripley.getInput().isKeyDown(Input.Key.RIGHT) == false && ripley.getInput().isKeyDown(Input.Key.LEFT)) {
            moveDownLeft.Execute();
        }
        if (ripley.getInput().isKeyDown(Input.Key.UP) && ripley.getInput().isKeyDown(Input.Key.DOWN) == false && ripley.getInput().isKeyDown(Input.Key.RIGHT) && ripley.getInput().isKeyDown(Input.Key.LEFT) == false) {
            moveUpRight.Execute();
        }
        if (ripley.getInput().isKeyDown(Input.Key.UP) && ripley.getInput().isKeyDown(Input.Key.DOWN) == false && ripley.getInput().isKeyDown(Input.Key.RIGHT) == false && ripley.getInput().isKeyDown(Input.Key.LEFT)) {
            moveUpLeft.Execute();
        }
        if (ripley.getInput().isKeyDown(Input.Key.UP) && ripley.getInput().isKeyDown(Input.Key.DOWN) == false && ripley.getInput().isKeyDown(Input.Key.RIGHT) == false && ripley.getInput().isKeyDown(Input.Key.LEFT) == false) {
            moveUp.Execute();
        }
        if (ripley.getInput().isKeyDown(Input.Key.UP) == false && ripley.getInput().isKeyDown(Input.Key.DOWN) && ripley.getInput().isKeyDown(Input.Key.RIGHT) == false && ripley.getInput().isKeyDown(Input.Key.LEFT) == false) {
            moveDown.Execute();
        }
        if (ripley.getInput().isKeyDown(Input.Key.UP) == false && ripley.getInput().isKeyDown(Input.Key.DOWN) == false && ripley.getInput().isKeyDown(Input.Key.RIGHT) && ripley.getInput().isKeyDown(Input.Key.LEFT) == false) {
            moveRight.Execute();
        }
        if (ripley.getInput().isKeyDown(Input.Key.UP) == false && ripley.getInput().isKeyDown(Input.Key.DOWN) == false && ripley.getInput().isKeyDown(Input.Key.RIGHT) == false && ripley.getInput().isKeyDown(Input.Key.LEFT)) {
            moveLeft.Execute();
        }
        
        if (ripley.getInput().isKeyPressed(Input.Key.E))
        {
            List<Use> usables = new ArrayList<>();
            
            for(Actor actor : ripley.getWorld())
            {
                if(ripley.getBackpack().items.size() > 0)
                {
                if(ripley.intersects(actor) && actor instanceof BrokenFan && ((BrokenFan)actor).isBroken() && ripley.getBackpack().getLastItem() instanceof Hammer && actor != ripley)
                {
                    usables.add(new Use(ripley.getBackpack().getLastItem(),actor));
                    ripley.getBackpack().remove(ripley.getBackpack().getLastItem());
                    
                }
                if(ripley.intersects(actor) && actor instanceof BrokenCooler && ripley.getBackpack().getLastItem() instanceof Wrench && actor != ripley)
                {
                    usables.add(new Use(ripley.getBackpack().getLastItem(),actor));
                    ripley.getBackpack().remove(ripley.getBackpack().getLastItem());
                    
                }                
                }
                
                if(actor instanceof Usable && ripley.intersects(actor) && actor != ripley)
                {
                    usables.add(new Use(actor,ripley));
                } 

            }
            if(usables.size() > 0)
            {
                for(Use use : usables)
                {
                    use.Execute();
                }
            }
            
        }
        
        if (ripley.getInput().isKeyPressed(Input.Key.ENTER))
        {
            Actor itemToBeRemoved = null;
            for(Actor actor : ripley.getWorld())
            {
                if(actor instanceof Item && ripley.intersects(actor))
                {
                    takeItem = new TakeItem(ripley.getBackpack(), (Item) actor);
                    itemToBeRemoved = actor;
                } 
            }
            if(takeItem != null && itemToBeRemoved != null) {
            takeItem.Execute();
            ripley.getWorld().removeActor(itemToBeRemoved);
            }
            
        }       
        
        if (ripley.getInput().isKeyPressed(Input.Key.BACK))
        {

            if(ripley.getBackpack().items.size() > 0) {

            dropItem = new DropItem(ripley.getBackpack(),ripley.getWorld(),ripley.getX(),ripley.getY());
            dropItem.Execute();
            }
        }
        
        if (ripley.getInput().isKeyPressed(Input.Key.N))
        {
            if(ripley.getBackpack().items.size() > 0)
            {
            nextItem = new NextItem(ripley.getBackpack());
            nextItem.Execute();
            ripley.getWorld().showBackpack(ripley.getBackpack());
            }
        }
        
        if (ripley.getInput().isKeyPressed(Input.Key.SPACE))
        {
            ripley.getGun().shoot();
        }
        
        if (ripley.getInput().isKeyPressed(Input.Key.R))
        {
            ripley.getOmniWave().shoot();
        }        
        
        if (ripley.getInput().isKeyPressed(Input.Key.G)){
            System.out.println(ripley.getX() + " " + ripley.getY());
        }
        
        
        for (Actor actor : ripley.getWorld()){
            
            if(ripley.intersects(actor) && actor instanceof FloorSwitch){
                ((FloorSwitch) actor).getMachine().floorSwitchActivated();
            }
            
            if(actor instanceof Lever){
                if(ripley.intersects(actor)) {
                ripley.getWorld().showMessage(new Message("Hidden lever found!",100,10));
                } 
            }   
            
            if(ripley.intersects(actor) && actor instanceof SmallExplosion && ((SmallExplosion) actor).getTimer() % 10 == 0){
                ripley.setHealth(ripley.getHealth() - 1);
                if(ripley.getHealth() <= 0)
                    ripley.setHealth(0);
            }
            
            if(actor instanceof Explosion){
                ((SmallExplosion) actor).setTimer(((SmallExplosion) actor).getTimer() - 1);
                if(((SmallExplosion) actor).getTimer() == 0){
                    toRemove.add(actor);
                        
                }
            }
            
        }
        for (Actor actor : toRemove){
                ripley.getWorld().removeActor(actor);
        }        
    }
    
}

