package HUD;

import Main.Handler;
import processing.core.PApplet;

/**
 * Created by Ben on 27/01/2017.
 */
public abstract class HudButton {

    protected Handler handler;
    protected int x, y, width,height;

    public HudButton(Handler handler, int x, int y) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 60;
    }

    public abstract void clicked();
    public abstract void mouseClicked(int x, int y);
    public abstract void mouseDragged(int x, int y);

    public abstract void update();
    public abstract void render();



}
