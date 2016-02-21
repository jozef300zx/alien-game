/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Input;

/**
 *
 * @author jmorvay
 */
public class Dying implements RipleyState{
    private Ripley ripley;
    
    public Dying(Ripley ripley){
        this.ripley = ripley;
        this.ripley.setName("dying ripley");
    }
    

    @Override
    public void act() {
        if (ripley.getInput().isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }        
    }
    
}
