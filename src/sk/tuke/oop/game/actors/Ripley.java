/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author admin
 */
public class Ripley extends AbstractActor implements Movable{
    private int health;
    
    public Ripley()
    {
        normalAnimation = new Animation("resources/sprites/player.png",32,32,100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        this.health = 100;
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
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    

    
}
