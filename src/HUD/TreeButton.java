package HUD;

import Main.Handler;


/**
 * Created by Ben on 27/01/2017.
 */
public class TreeButton extends HudButton {




    public TreeButton(Handler handler, int x, int y) {
        super(handler, x, y);
    }


    @Override
    public void clicked() {

    }

    @Override
    public void mouseClicked(int x, int y) {

    }

    @Override
    public void mouseDragged(int x, int y) {

    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        handler.getGame().fill(0,255,0,240);
        handler.getGame().rect(x,y,width,height);
    }
}
