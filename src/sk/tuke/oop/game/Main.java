package sk.tuke.oop.game;

import sk.tuke.oop.game.actors.Ripley;
import sk.tuke.oop.game.actors.Alien;
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
        Alien alien = new Alien();
        
        ripley.setPosition(300, 300);
        alien.setPosition(500, 300);
        slickWorld.addActor(ripley);
        slickWorld.addActor(alien);
        slickWorld.run();
    }
    
}
