package Main;

import Entities.GameObject;
import Entities.ObjectId;
import Entities.Player;
import Level.LevelLoader;

import java.util.ArrayList;

/**
 * Created by Ben on 26/01/2017.
 */
public class Handler {

    private Game game;
    private ArrayList<GameObject> objects;

    public Handler(Game game){
        this.game = game;
        objects = new ArrayList<>();
        new LevelLoader(this);
    }

    public Game getGame(){
        return game;
    }

    public void addObject(GameObject obj){
        objects.add(obj);
    }

    public ArrayList<GameObject> getObjects(){
        return objects;
    }

    public void keyPressed(int key){

        if(key == 'd'){
            getPlayer().move(1);
        }
        if(key == 'a'){
            getPlayer().move(-1);
        }

        if(key == ' '){
            getPlayer().jump();
        }


    }

    public void keyReleased(int key){

        if(key == 'd'){
            getPlayer().move(0);
        }
        if(key == 'a'){
            getPlayer().move(0);
        }
    }


    private Player getPlayer(){
        for(GameObject obj : objects){
            if(obj.getId() == ObjectId.PLAYER){
                return (Player) obj;
            }
        }

        return null;
    }




}
