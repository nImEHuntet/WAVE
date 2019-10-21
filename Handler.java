 

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> obj = new LinkedList<GameObject>();
    
    public void tick() {
        for (int i = 0; i < obj.size(); i++) {
            GameObject tmpObj = obj.get(i);            
            tmpObj.tick();
        }
    }
    public void render(Graphics g) {
        for (int i = 0; i < obj.size(); i++) {
            GameObject tmpObj = obj.get(i);
            tmpObj.render(g);
        }
    }

    public void clearEnemy(){
        for (int i = 0; i < obj.size(); i++) {
            GameObject tmpObj = obj.get(i);
            if(tmpObj.getId() != ID.Player){
                obj.clear();
                if(Game.gameState != Game.STATE.End)
                addObj(new Player((int)tmpObj.getX(),(int)tmpObj.getY() , ID.Player, this));
            }
        }   
    }
    
    public void addObj(GameObject obj) {
        this.obj.add(obj);
    }
    public void removeObj(GameObject obj) {
        this.obj.remove(obj);
    }    
}