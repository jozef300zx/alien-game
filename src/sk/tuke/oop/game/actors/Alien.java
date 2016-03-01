/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author admin
 */
public class Alien extends AbstractCharacter implements Movable, Enemy{
    static int alienCount;
    private AlienState state;
    

    
    public Alien()
    {
        normalAnimation = new Animation("resources/sprites/warrior_alien.png",32,32,100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        step = 2;
        setHealth(20);
        state = new Active(this);
        alienCount++;
    }
    
    @Override
    public void act() { 
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
	LargeExplosion impact = new LargeExplosion();
	impact.setPosition(getX(),getY());
	impact.getAnimation().setDuration(10);
	impact.setTimer(10);
	getWorld().addActor(impact);
	impact.explode();  
        
        if(--alienCount == 0){
            System.exit(0);
        }
        } 
    }
}

