package Entities;

import Main.Handler;

import java.util.ArrayList;

/**
 * Created by Ben on 27/01/2017.
 */
public class Tree extends GameObject {


    private int velY = 0;
    private int gravity = 2;
    boolean falling = false;

    public Tree(Handler handler, int x, int y, ObjectId id) {
        super(handler, x, y, 30, 50, id);
    }

    @Override
    public void update(ArrayList<GameObject> objects) {


        for(GameObject obj : objects){

            if(obj.getId() == ObjectId.BLOCK){
                if(!obj.getBounds().intersects(getBounds())){
                    falling = true;
                }else{
                    falling = false;
                    velY = 0;
                    y = obj.getY() - height;
                }
            }

        }

        if(falling){
            velY+=gravity;
        }

        y += velY;


    }

    @Override
    public void render() {
        game.fill(0,255,0);
        game.rect(x,y,width,height);
    }
}
