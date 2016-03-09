/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.alien.Active;
import sk.tuke.oop.game.actors.alien.Alien;

/**
 *
 * @author jmorvay
 */
public class Hole extends  AbstractActor implements Observer{
    private int timer;
    private boolean spawn;
    public Hole(){
        normalAnimation = new Animation("resources/sprites/hole.png",32,32,150);
        setAnimation(normalAnimation);     
        normalAnimation.stop();
        normalAnimation.setLooping(false);
        timer = 350;
    }    

    @Override
    public void giveNotice() {
        normalAnimation.start();
        spawn = true;
    }
    
    public void act(){
        if(spawn){
            if(timer % 150 == 0 && timer < 350){
                Alien alien  = new Alien();
                alien.setState(new Active(alien));
                alien.setPosition(this.getX(), this.getY());
                getWorld().addActor(alien);
            }
            
            if(timer > 1){
                timer--;
            }
        }

    }

    @Override
    public void giveNotice(Trigger trigger) {
    }
    
}
