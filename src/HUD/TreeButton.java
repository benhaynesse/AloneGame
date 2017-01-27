package HUD;

import Entities.ObjectId;
import Entities.Tree;
import Main.Handler;


/**
 * Created by Ben on 27/01/2017.
 */
public class TreeButton extends HudButton {




    public TreeButton(Handler handler, int x, int y) {
        super(handler, x, y);
    }


    @Override
    public void action(int x, int y) {
        handler.addObject(new Tree(handler, x,y, ObjectId.TREE));
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
