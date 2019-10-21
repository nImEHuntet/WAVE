 

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends  GameObject{
    
    private Handler handler;
    Random r = new Random();
    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        valX = (r.nextInt(5 - -5) + -5);
        valY = 5;
    }

    @Override
    public void tick() {
        x += valX;
        y += valY;
        
        //if(y <= 0 || y >= Game.HEIGHT -32) valY *= -1;
        //if(x <= 0 || x >= Game.WIDTH -16) valX *= -1;
        if(y >= Game.HEIGHT) handler.removeObj(this);
        handler.addObj(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));            
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16);
    }
     @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16,16);
    }  
}
