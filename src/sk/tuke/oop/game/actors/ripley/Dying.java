/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Message;

/**
 *
 * @author jmorvay
 */
public class Dying implements RipleyState{
    private Ripley ripley;
    Animation deadAnimation;
    int animationTimer;
    
    public Dying(Ripley ripley){
        this.ripley = ripley;
        this.ripley.setName("dying ripley");
        deadAnimation = new Animation("resources/sprites/player_die.png",32,32,100);
        animationTimer = 150;
    }
    

    @Override
    public void act() {
        if(ripley.getAnimation() != deadAnimation) {
        ripley.setAnimation(deadAnimation);
        ripley.getWorld().showMessage(new Message("You're dead!",100,10));
        }
        ripley.getAnimation().start();
        animationTimer -= 1;
        if(animationTimer == 0)
            System.exit(0);
    

        if (ripley.getInput().isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }        
    
    
}
    
}
