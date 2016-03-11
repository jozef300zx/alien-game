/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class Generator extends AbstractActor implements Observer{
    private boolean shootLightning;
    Generator()
    {
        normalAnimation = new Animation("resources/sprites/generator.png",32,16,100);
        setAnimation(normalAnimation);
        normalAnimation.setRotation(90);
        normalAnimation.start();
    }    
    
    public void act(){
        if(this.shootLightning){
            double i = Math.random();
            if(i > 0 && i <= 0.02){
                Lightning lightning = new Lightning();
                lightning.setPosition(this.getX() + 8, this.getY() + 24);
                getWorld().addActor(lightning);
            }
        }
    }

    @Override
    public void giveNotice(Trigger trigger) {
    }

    @Override
    public void giveNotice() {
        this.shootLightning = true;
    }
    
}
