package sk.tuke.oop.game;

import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.ActorFactoryImpl;


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
        ActorFactoryImpl factory = new ActorFactoryImpl();
        
        slickWorld.setFactory(factory);
        //slickWorld.setMap("/resources/levels/level04.xml");        
        slickWorld.setMap("/resources/levels/map.tmx");
        slickWorld.run();
      
        
    }
    
}
