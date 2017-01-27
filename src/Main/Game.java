package Main;

import Entities.GameObject;
import Entities.LevelBlock;
import Entities.ObjectId;
import Entities.Player;
import Level.LevelLoader;
import processing.core.PApplet;

import java.util.ArrayList;

/**
 * Created by Ben on 19/01/2017.
 */
public class Game extends PApplet {

    private Handler handler;
    private HUD.HUD hud;
    ArrayList<GameObject> objects;


    public void settings() {
        size(900, 600);
    }

    public void setup() {
        handler = new Handler(this);
        handler.addObject(new Player(handler, 50,50,ObjectId.PLAYER));
        objects = handler.getObjects();




        hud = new HUD.HUD(handler);

    }


    public void update() {
        for(GameObject obj : objects){
            obj.update(objects);
        }
    }


    public void draw() {
        background(0);
        frame.requestFocus();

        update();

        for(GameObject obj : objects){
            obj.render();
        }


        hud.render();

    }

    public void mousePressed() {
        if (hud.getBounds().contains(mouseX, mouseY)) {
            if (hud.isVisible())
                hud.mousePressed(mouseX, mouseY);
        }
    }

    public void mouseDragged() {

        if (hud.isVisible()) {
            hud.mouseDragged(mouseX, mouseY);
        }
    }

    public void mouseReleased() {

        if (hud.isVisible()) {
            hud.mouseReleased(mouseX, mouseY);
        }

    }


    public void keyPressed() {
        if (key == 9) {
            if (hud.isVisible()) {
                hud.setVisible(false);
            } else {
                hud.setVisible(true);
            }

        } else {
            handler.keyPressed(key);
        }

    }

    public void keyReleased() {
        handler.keyReleased(key);
    }


    public static void main(String[] args) {
        PApplet.main("Main.Game");
    }

}
