package Level;

import Entities.LevelBlock;
import Entities.ObjectId;
import Main.Handler;

/**
 * Created by Ben on 26/01/2017.
 */
public class LevelLoader {

    private Handler handler;
    private int width, height, bs;


    public LevelLoader(Handler handler){
        this.handler = handler;
        bs = LevelBlock.blockSize;
        width = handler.getGame().width;
        height = handler.getGame().height;
        generateFloor();
        generateSides();
        generateLedge(width/32/2-4,height/32 - 5,9);
    }

    private void generateFloor(){

        for(int i = 0; i < width/bs; i++){
            handler.addObject(new LevelBlock(handler, i*bs, height - bs, ObjectId.BLOCK));
        }
    }

    private void generateSides(){

        //Left Wall
        for(int i = 0; i < height/bs; i++){
            handler.addObject(new LevelBlock(handler, 0, i*bs, ObjectId.BLOCK));
        }
        //Right Wall
        for(int i = 0; i < height/bs; i++){
            handler.addObject(new LevelBlock(handler, width-bs, i*bs, ObjectId.BLOCK));
        }
    }

    private void generateLedge(int x, int y, int length){

        for(int i = x; i < length+x; i++){
            handler.addObject(new LevelBlock(handler, i*bs,y*bs,ObjectId.BLOCK));
        }


    }



}
