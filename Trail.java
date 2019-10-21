 

import java.awt.*;

public class Trail extends  GameObject{

    private float alpha = 1;
    private Handler handler;
    private Color color;
    private  int width, height;
    float life;
    //life = 0.001 - 0.1
    public Trail(float x, float y, ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width= width;
        this.height = height;
        this.life = life;
    }

    @Override
    public void tick() {
        if(alpha > life){
            alpha -= (life - 0.001f);
        }
        else
            handler.removeObj(this);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setComposite(makeTrasparent(alpha));
        
        g.setColor(color);
        g.fillRect((int)x, (int)y, width, height);
        
        g2d.setComposite(makeTrasparent(1));
    }

    private  AlphaComposite makeTrasparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }
    
    @Override
    public Rectangle getBounds() {
        return null;
    }    
}