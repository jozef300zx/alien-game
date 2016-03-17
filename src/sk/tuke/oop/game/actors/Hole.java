/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.alien.Active;
import sk.tuke.oop.game.actors.alien.Alien;
import sk.tuke.oop.game.actors.alien.Waiting;

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

    }
    
    public void act(){
        if(spawn){
            if(timer % 150 == 0){
                Alien alien  = new Alien();
                if(this.getName().equals("waiting hole")){
                    alien.setState(new Waiting(alien));  
                    alien.setType("7.7");
                } else {
                    alien.setState(new Active(alien));
                }
                alien.setPosition(this.getX(), this.getY());
                getWorld().addActor(alien);
            }
            
            if(timer > 1){
            timer--;
            }
            if(timer == 1){
                this.spawn = false;
            }            
        }

    }

    @Override
    public void giveNotice(Trigger trigger) {
        normalAnimation.start();
        spawn = true;
        trigger.removeObserver(this);
    }
    
}
