 

import java.awt.*;

public class FastEnemy extends  GameObject{
    
    private Handler handler;
    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        valX = 2;
        valY = 9;
    }

    @Override
    public void tick() {
        x += valX;
        y += valY;
        
        if(y <= 0 || y >= Game.HEIGHT -32) valY *= -1;
        if(x <= 0 || x >= Game.WIDTH -16) valX *= -1;
        
        handler.addObj(new Trail(x, y, ID.Trail, Color.CYAN, 16, 16, 0.02f, handler));
            
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, 16, 16);
    }
     @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16,16);
    }  
}
