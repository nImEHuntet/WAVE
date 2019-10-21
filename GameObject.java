 

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    protected float x,y;
    protected ID id;
    protected float valX, valY;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;        
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public float getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public float getY() {
        return y;
    }
    public ID getId() {
        return id;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public void setValX(int valX) {
        this.valX = valX;
    }
    public float getValX() {
        return valX;
    }
    public float getValY() {
        return valY;
    }
    public void setValY(int valY) {
        this.valY = valY;
    }    
    
}
