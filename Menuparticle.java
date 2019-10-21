 

import java.awt.*;
import java.util.Random;

public class Menuparticle extends  GameObject{
    
    private Handler handler;
    Random r = new Random();
    
    private Color col;
    
    
    public Menuparticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        //to move left as well as top down
valX = (r.nextInt(6 - -6) + -6);
        valY = (r.nextInt(6 - -6) + -6);
        
        if(valX ==0) valX =1;
        if(valY ==0) valY =1;
        
        col = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
    }

    @Override
    public void tick() {
        x += valX;
        y += valY;
        
        if(y <= 0 || y >= Game.HEIGHT -32) valY *= -1;
        if(x <= 0 || x >= Game.WIDTH -16) valX *= -1;
        
        handler.addObj(new Trail(x, y, ID.Trail, col, 16, 16, 0.05f, handler));
            
    }

    @Override
    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int)x, (int)y, 16, 16);
    }
     @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16,16);
    }  
}
