package HUD;

import Main.Handler;
import processing.core.PApplet;

import java.awt.*;

/**
 * Created by Ben on 27/01/2017.
 */
public abstract class HudButton {

    protected Handler handler;
    protected int x, y, width,height;
    protected int initX, initY;
    protected boolean clicked = false, placed = false;

    public HudButton(Handler handler, int x, int y) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 60;
        initX = x;
        initY = y;
    }

    public abstract void action(int x, int y);

    public void mousePressed(int x, int y) {
        if(getBounds().contains(x,y)){
            clicked = true;
        }
    }


    public void mouseDragged(int x, int y) {
        if(clicked){
            this.x = x - width/2;
            this.y = y - height/2;
        }
    }


    public void mouseReleased(int x, int y){
        if(this.y + height < 500){
           // placed = true;
            action(x,y);
        }

        if(!placed){
            this.x = initX;
            this.y = initY;
        }

        clicked = false;
    }

    public abstract void update();
    public abstract void render();


    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }



}
