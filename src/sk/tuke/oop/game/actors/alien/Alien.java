/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.alien;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.LargeExplosion;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.Trigger;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author admin
 */
public class Alien extends AbstractCharacter implements Movable, Enemy, Observer{
    private AlienState state;
    private Move moveUp;
    private Move moveDown;
    private Move moveRight;
    private Move moveLeft;
    private Move moveDownRight;
    private Move moveDownLeft;
    private Move moveUpRight;
    private Move moveUpLeft;     
    private Ripley ripley; 
    private Trigger trigger;

    
    public Alien()
    {
        normalAnimation = new Animation("resources/sprites/warrior_alien.png",32,32,100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        setHealth(20);
        state = new Waiting(this);
        setStep(1);
    }
    
    @Override
    public void act() { 
        if(getRipley() == null)
        {
            for(Actor actor : getWorld())
            {
                if(actor instanceof Ripley)
                {
                    setRipley((Ripley) actor);
                }
            }
        }
        if(getMoveUp() == null)
        {
            setMoveUp(new Move(this,getStep(),0,-1));
        }
        if(getMoveDown() == null)
        {
            setMoveDown(new Move(this,getStep(),0,1));
        }
        if(getMoveRight() == null)
        {
            setMoveRight(new Move(this,getStep(),1,0));
        }
        if(getMoveLeft() == null)
        {
            setMoveLeft(new Move(this,getStep(),-1,0));
        }
        if(getMoveDownRight() == null)
        {
            setMoveDownRight(new Move(this,getStep(),1,1));
        }
        if(getMoveDownLeft() == null)
        {
            setMoveDownLeft(new Move(this,getStep(),-1,1));
        }
        if(getMoveUpRight() == null)
        {
            setMoveUpRight(new Move(this,getStep(),1,-1));
        }
        if(getMoveUpLeft() == null)
        {
            setMoveUpLeft(new Move(this,getStep(),-1,-1));
        }
        
        getState().act();
    } 

    public AlienState getState() {
        return state;
    }

    public void setState(AlienState state) {
        this.state = state;
    }

    public void die(){
	if(getHealth() <= 0){
	getWorld().removeActor(this);
        if(getTrigger() != null){
        getTrigger().removeObserver(this);
        }
	LargeExplosion impact = new LargeExplosion();
	impact.setPosition(getX(),getY());
	impact.getAnimation().setDuration(20);
	impact.setTimer(20);
	getWorld().addActor(impact);
	impact.explode();  
        } 
    }

    public void detectColision(){
        
    }
    
    public Move getMoveUp() {
        return moveUp;
    }

    public void setMoveUp(Move moveUp) {
        this.moveUp = moveUp;
    }

    public Move getMoveDown() {
        return moveDown;
    }

    public void setMoveDown(Move moveDown) {
        this.moveDown = moveDown;
    }

    public Move getMoveRight() {
        return moveRight;
    }

    public void setMoveRight(Move moveRight) {
        this.moveRight = moveRight;
    }

    public Move getMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(Move moveLeft) {
        this.moveLeft = moveLeft;
    }

    public Move getMoveDownRight() {
        return moveDownRight;
    }

    public void setMoveDownRight(Move moveDownRight) {
        this.moveDownRight = moveDownRight;
    }

    public Move getMoveDownLeft() {
        return moveDownLeft;
    }

    public void setMoveDownLeft(Move moveDownLeft) {
        this.moveDownLeft = moveDownLeft;
    }

    public Move getMoveUpRight() {
        return moveUpRight;
    }

    public void setMoveUpRight(Move moveUpRight) {
        this.moveUpRight = moveUpRight;
    }

    public Move getMoveUpLeft() {
        return moveUpLeft;
    }

    public void setMoveUpLeft(Move moveUpLeft) {
        this.moveUpLeft = moveUpLeft;
    }

    public Ripley getRipley() {
        return ripley;
    }

    public void setRipley(Ripley ripley) {
        this.ripley = ripley;
    }

    @Override
    public void giveNotice(Trigger trigger) {
        if(!(getState() instanceof Active)){
        setState(new Active(this));
        } else {
        setState(new Waiting(this));
        }        
        if(this.getTrigger() == null){
            this.setTrigger(trigger);
        }
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    @Override
    public void giveNotice() {
    }
}

