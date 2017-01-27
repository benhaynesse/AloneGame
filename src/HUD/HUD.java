package HUD;

import Main.Game;
import Main.Handler;

import java.awt.*;
import java.util.ArrayList;


/**
 * Created by Ben on 26/01/2017.
 */
public class HUD {

    private Handler handler;
    private Game game;
    private boolean visible = false;
    private int x, y, width, height;


    ArrayList<HudButton> buttons;


    public HUD(Handler handler) {
        this.handler = handler;
        this.game = handler.getGame();
        this.width = game.width;
        this.height = 100;
        this.x = 0;
        this.y = game.height - this.height;

        buttons = new ArrayList<HudButton>();
        buttons.add(new TreeButton(handler,x+50, y+2));
        buttons.add(new StoneButton(handler, x+150, y+2));


    }


    public void update() {

    }

    public void render() {

        if (visible) {
            game.fill(120, 235);
            game.rect(0, game.height - 100, game.width, 100);

            for(HudButton btn : buttons){
                btn.render();
            }

        }

    }

    public void mousePressed(int x, int y) {

        for(HudButton btn : buttons){
            if(btn.getBounds().contains(x,y)){
                btn.mousePressed(x,y);
            }
        }


    }

    public void mouseDragged(int x, int y) {
        for(HudButton btn : buttons){
            if(btn.getBounds().contains(x,y)){
                btn.mouseDragged(x,y);
            }
        }
    }

    public void mouseReleased(int x, int y) {
        for(HudButton btn : buttons){
            if(btn.getBounds().contains(x,y)){
                btn.mouseReleased(x,y);
            }
        }
    }


    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        for(HudButton btn : buttons){
            btn.x = btn.initX;
            btn.y = btn.initY;
        }
    }

    public int getX() {
        return x;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
