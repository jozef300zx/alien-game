/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.actors.alien.Enemy;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class Barrel extends AbstractCharacter implements Enemy{
    private boolean initialCycle;
    
    public Barrel()
    {
        normalAnimation = new Animation("resources/sprites/barrel.png",16,16,100);
        setAnimation(normalAnimation);
        setHealth(5);
        initialCycle = true;
    }    
    
    @Override
    public void act(){
        if(initialCycle){
            //set wall
            getWorld().setWall(this.getX() / 16, this.getY() / 16, true);
        }
        
        
        
        destroyed();
    }
    
    public void destroyed(){
	if(getHealth() <= 0){
	getWorld().removeActor(this);
	DamagingExplosion impact = new DamagingExplosion();
	impact.setPosition(getX() - 8,getY() - 8);
	impact.getAnimation().setDuration(20);
	impact.setTimer(20);
	getWorld().addActor(impact);
	impact.explode();  
        getWorld().setWall(this.getX() / 16, this.getY() / 16, false);
        }
    }

}
    

