package HUD;

import Main.Handler;

/**
 * Created by Ben on 27/01/2017.
 */
public class StoneButton extends HudButton {

    public StoneButton(Handler handler, int x, int y) {
        super(handler, x, y);
    }

    @Override
    public void action(int x, int y) {

    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        handler.getGame().fill(122,240);
        handler.getGame().rect(x,y,width,height);
    }
}
