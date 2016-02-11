/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.game.commands.TakeItem;
import sk.tuke.oop.game.commands.Use;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author admin
 */
public class Ripley extends AbstractActor implements Movable{
    private int health;
    private int ammo;
    private Use use;
    private TakeItem takeItem;
    private DropItem dropItem;
    private BackpackImpl backpack;
    
    public Ripley()
    {
        normalAnimation = new Animation("resources/sprites/player.png",32,32,100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        this.health = 100;
        this.ammo = 100;
        this.backpack = new BackpackImpl(3);
    }
    
        public void act() {
        input = Input.getInstance();
        normalAnimation.stop();
        //inicializacia
        if (moveUp == null) {
            moveUp = new Move(this, 2, 0, -1);
        }
        if (moveDown == null) {
            moveDown = new Move(this, 2, 0, 1);
        }
        if (moveRight == null) {
            moveRight = new Move(this, 2, 1, 0);
        }
        if (moveLeft == null) {
            moveLeft = new Move(this, 2, -1, 0);
        }
        if (moveDownRight == null) {
            moveDownRight = new Move(this, 2, 1, 1);
        }
        if (moveDownLeft == null) {
            moveDownLeft = new Move(this, 2, -1, 1);
        }
        if (moveUpRight == null) {
            moveUpRight = new Move(this, 2, 1, -1);
        }
        if (moveUpLeft == null) {
            moveUpLeft = new Move(this, 2, -1, -1);
        }
        //pohyby
        if (input.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }
        if (input.isKeyDown(Input.Key.UP) == false && input.isKeyDown(Input.Key.DOWN) && input.isKeyDown(Input.Key.RIGHT) && input.isKeyDown(Input.Key.LEFT) == false) {
            moveDownRight.Execute();
        }
        if (input.isKeyDown(Input.Key.UP) == false && input.isKeyDown(Input.Key.DOWN) && input.isKeyDown(Input.Key.RIGHT) == false && input.isKeyDown(Input.Key.LEFT)) {
            moveDownLeft.Execute();
        }
        if (input.isKeyDown(Input.Key.UP) && input.isKeyDown(Input.Key.DOWN) == false && input.isKeyDown(Input.Key.RIGHT) && input.isKeyDown(Input.Key.LEFT) == false) {
            moveUpRight.Execute();
        }
        if (input.isKeyDown(Input.Key.UP) && input.isKeyDown(Input.Key.DOWN) == false && input.isKeyDown(Input.Key.RIGHT) == false && input.isKeyDown(Input.Key.LEFT)) {
            moveUpLeft.Execute();
        }
        if (input.isKeyDown(Input.Key.UP) && input.isKeyDown(Input.Key.DOWN) == false && input.isKeyDown(Input.Key.RIGHT) == false && input.isKeyDown(Input.Key.LEFT) == false) {
            moveUp.Execute();
        }
        if (input.isKeyDown(Input.Key.UP) == false && input.isKeyDown(Input.Key.DOWN) && input.isKeyDown(Input.Key.RIGHT) == false && input.isKeyDown(Input.Key.LEFT) == false) {
            moveDown.Execute();
        }
        if (input.isKeyDown(Input.Key.UP) == false && input.isKeyDown(Input.Key.DOWN) == false && input.isKeyDown(Input.Key.RIGHT) && input.isKeyDown(Input.Key.LEFT) == false) {
            moveRight.Execute();
        }
        if (input.isKeyDown(Input.Key.UP) == false && input.isKeyDown(Input.Key.DOWN) == false && input.isKeyDown(Input.Key.RIGHT) == false && input.isKeyDown(Input.Key.LEFT)) {
            moveLeft.Execute();
        }
        
        if (input.isKeyPressed(Input.Key.E))
        {
            for(Actor actor : getWorld())
            {
                if(actor instanceof Usable && this.intersects(actor))
                {
                    use = new Use(actor,this);
                    use.Execute();
                } 

            }
        }
        
        if (input.isKeyPressed(Input.Key.ENTER))
        {
            for(Actor actor : getWorld())
            {
                if(actor instanceof Item && this.intersects(actor))
                {
                    takeItem = new TakeItem(backpack, (Item) actor);
                } 
            }
        }       
        
        if (input.isKeyPressed(Input.Key.BACK))
        {
            int droppedX,droppedY;
            if(this.getAnimation().getRotation() == 0)
            {
                droppedX = this.getX() + this.getWidth()/2;
                droppedY = this.getY();
            }
            if(this.getAnimation().getRotation() == 45)
            {
                droppedX = this.getX() + this.getWidth();
                droppedY = this.getY();
            }
            if(this.getAnimation().getRotation() == 90)
            {
                droppedX = this.getX() + this.getWidth();
                droppedY = this.getY() + this.getHeight()/2;
            }
            if(this.getAnimation().getRotation() == 135)
            {
                droppedX = this.getX() + this.getWidth();
                droppedY = this.getY() + this.getHeight();
            }    
            if(this.getAnimation().getRotation() == 180)
            {
                droppedX = this.getX() + this.getWidth()/2;
                droppedY = this.getY() + this.getHeight();
            }  
            if(this.getAnimation().getRotation() == 225)
            {
                droppedX = this.getX();
                droppedY = this.getY() + this.getHeight();
            }    
            if(this.getAnimation().getRotation() == 270)
            {
                droppedX = this.getX();
                droppedY = this.getY() + this.getHeight()/2;
            } 
            if(this.getAnimation().getRotation() == 315)
            {
                droppedX = this.getX();
                droppedY = this.getY();
            }            
            dropItem = new DropItem(this.backpack,this.world,this.getX(),this.getY());
        }           
        
        
        if(this.health <= 0)
        {
            System.exit(0);
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public void addedToWorld(World world) {
        this.world = world;
        this.world.showBackpack(backpack);
        
    }

    

    
}
