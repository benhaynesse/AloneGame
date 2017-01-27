package Main;

import Entities.GameObject;
import Entities.ObjectId;
import Entities.Player;
import Level.LevelLoader;
import processing.core.PApplet;

import java.util.ArrayList;

/**
 * Created by Ben on 19/01/2017.
 */
public class Game extends PApplet{

    private Handler handler;
    private HUD.HUD hud;
    private ArrayList<GameObject> objects;



    public void settings(){
        size(900,600);
    }

    public void setup(){
        handler = new Handler(this);
        objects = handler.getObjects();
        handler.addObject(new Player(handler, 50,50,ObjectId.PLAYER));
        hud = new HUD.HUD(handler);

    }


    public void update(){
        for(GameObject obj : objects){
            obj.update(objects);
        }
    }


    public void draw(){
        background(0);
        frame.requestFocus();

        update();

        for(GameObject obj : objects){
            obj.render();
        }

        hud.render();

    }

    public void mousePressed(){

    }

    public void mouseReleased(){

    }

    public void mouseMoved(){
        if(hud.isVisible()) {
            if (mouseX > hud.getX() && mouseX < hud.getX() + hud.getWidth()) {
                if (mouseY > hud.getY() && mouseY < hud.getY() + hud.getHeight()) {
                    System.out.println("INSIDE HUD");
                }
            }
        }
    }


    public void keyPressed(){
        if(key == 9){
            if(hud.isVisible()){
                hud.setVisible(false);
            }else{
                hud.setVisible(true);
            }

        }else {
            handler.keyPressed(key);
        }

    }

    public void keyReleased(){
        handler.keyReleased(key);
    }


    public static void main(String[] args) {
        PApplet.main("Main.Game");
    }

}
