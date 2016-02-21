package sk.tuke.oop.game;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.ActorFactoryImpl;
import sk.tuke.oop.game.actors.openables.Door;


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
        

        
        slickWorld.setMap("/resources/levels/level03.xml");
        for (Actor actor : slickWorld) {
            if(actor instanceof Door){
                if(actor.getHeight() > actor.getWidth()) {
                    slickWorld.setWall(actor.getX() / 16, actor.getY() / 16, true);
                    slickWorld.setWall(actor.getX() / 16, (actor.getY() + 16) / 16, true);
                }
        
                if(actor.getWidth() > actor.getHeight()) {
                    slickWorld.setWall(actor.getX() / 16, actor.getY() / 16, true);
                    slickWorld.setWall((actor.getX() + 16) / 16, actor.getY() / 16, true);    
                }
            }
        }
        
        
        slickWorld.run();
      
        
    }
    
}
