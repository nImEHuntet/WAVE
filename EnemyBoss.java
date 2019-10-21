 

import java.awt.*;
import java.util.Random;

public class EnemyBoss extends  GameObject{
    
    private Handler handler;
    private int timer = 50;
    private int timer2 = 50;
    Random r = new Random();
    public EnemyBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        valX = 0;
        valY = 2;
    }

    @Override
    public void tick() {
        x += valX;
        y += valY;
        
        if(timer <=0) valY = 0;
        else timer--;
        
        if(timer <= 0) timer2--;
        
        if(timer2 <=0)
        {
            if(valX==0) valX = 2;
            
            if(valX>0)
                valX +=0.005f;
            else if(valX < 0)
                valX -= 0.005f;
            
            valX =  Game.clamp(valX, -10, 10);
            int spawn = r.nextInt(10);
            if(spawn ==0)
                handler.addObj(new EnemyBossBullet((int)x+48, (int)y+48 , ID.BasicEnemy, handler));
        }        
        //if(y <= 0 || y >= Game.HEIGHT -32) valY *= -1;
        if(x <= 0 || x >= Game.WIDTH -96) valX *= -1;
        
        //handler.addObj(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));            
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)x, (int)y, 96, 96);
    }
     @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 96,96);
    }  
}
