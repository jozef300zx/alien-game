package sk.tuke.oop.game;

import sk.tuke.oop.framework.SlickWorld;


/**
 *
 * @author Manager
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SlickWorld slickWorld = new SlickWorld("Aliens",800,600);
        Ripley ripley = new Ripley();
        
        ripley.setPosition(400, 300);
        slickWorld.addActor(ripley);
        slickWorld.run();
    }
    
}
