package sk.tuke.oop.game;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.Ripley;
import sk.tuke.oop.game.actors.Alien;
import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.ActorFactoryImpl;
import sk.tuke.oop.game.actors.Body;
import sk.tuke.oop.game.actors.Cooler;
import sk.tuke.oop.game.actors.Door;
import sk.tuke.oop.game.actors.Ventilator;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;


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
        /*
        Ripley ripley = new Ripley();
        Alien alien = new Alien();
        Energy energy = new Energy();
        Ammo ammo = new Ammo();
        Ammo ammo2 = new Ammo();
        Ventilator ventilator = new Ventilator();
        Ventilator ventilator2 = new Ventilator();
        Body body = new Body();
        Cooler cooler = new Cooler();
        Cooler cooler2 = new Cooler();
        
        
        
        
        ripley.setHealth(50);
        ripley.setPosition(300, 300);
        
        energy.setPosition(200, 300);
        
        alien.setPosition(500, 300);
        
        ammo.setPosition(400, 200);
        ammo2.setPosition(300, 200);
        
        ventilator.setPosition(100, 100);
        ventilator2.setPosition(100, 130);
        cooler.setPosition(300, 70);
        cooler2.setPosition(330, 70);
        
        body.setPosition(500, 200);
        
        
        slickWorld.addActor(ripley);
        slickWorld.addActor(energy);
        slickWorld.addActor(ammo);
        slickWorld.addActor(ammo2);
        slickWorld.addActor(alien);
        slickWorld.addActor(ventilator);
        slickWorld.addActor(ventilator2);
        slickWorld.addActor(body);
        slickWorld.addActor(cooler);
        slickWorld.addActor(cooler2);
*/
        
        
        
        
        slickWorld.setFactory(factory);
        

        
        slickWorld.setMap("/resources/levels/level02.xml");
        for(Actor actor : slickWorld){
            if(actor instanceof Door){
            slickWorld.setWall(6, 4, true);
            slickWorld.setWall(6, 5, true);
            }
        }        
        
        
        slickWorld.run();
      
        
    }
    
}
