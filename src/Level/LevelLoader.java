package Level;

import Entities.LevelBlock;
import Entities.ObjectId;
import Entities.Player;
import Image.ImageLoader;
import Main.Handler;

import java.awt.image.BufferedImage;

/**
 * Created by Ben on 26/01/2017.
 */
public class LevelLoader {

    private Handler handler;
    private int width, height, bs;

    private BufferedImage level;


    public LevelLoader(Handler handler){
        this.handler = handler;
        bs = LevelBlock.blockSize;
       // width = handler.getGame().width;
       // height = handler.getGame().height;
        ImageLoader loader = new ImageLoader();
        level = loader.loadImage("level1.png");
        width = level.getWidth();
        height = level.getHeight();
//        generateFloor();
//        generateSides();
//        generateLedge(width/32/2-4,height/32 - 5,9);

generateLevel();
    }

    private void generateLevel(){

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int pixel = level.getRGB(x,y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if(red == 0 && green == 0 && blue == 0){
                    handler.addObject(new LevelBlock(handler, x*bs,y*bs,ObjectId.BLOCK));
                }else if(red == 255 && green == 0 && blue == 0){
                    Player p = new Player(handler, x*bs, y*bs, ObjectId.PLAYER);
                    handler.addObject(p);
                }

            }
        }

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
