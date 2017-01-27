package HUD;

import Main.Game;
import Main.Handler;

/**
 * Created by Ben on 26/01/2017.
 */
public class HUD {

    private Handler handler;
    private Game game;
    private boolean visible = false;
    private int x, y, width, height;

    public HUD(Handler handler){
        this.handler = handler;
        this.game = handler.getGame();
        this.width = game.width;
        this.height = 100;
        this.x = 0;
        this.y = game.height - this.height;
    }


    public void update(){

    }

    public void render(){

        if(visible) {
            game.fill(120, 235);
            game.rect(0, game.height - 100, game.width, 100);
        }

    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getX() {
        return x;
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
