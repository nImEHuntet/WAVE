 

import java.awt.*;

public class SmartEnemy extends  GameObject{
    
    private Handler handler;
    private GameObject player;
    
    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
        for (int i = 0; i < handler.obj.size(); i++) {
            if(handler.obj.get(i).getId()==ID.Player) player = handler.obj.get(i);
        }
        
    }

    @Override
    public void tick() {
        x += valX;
        y += valY;
        
        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float)Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
        
        valX = (int) ((-1.0/distance) * diffX);
        valY = (int) ((-1.0/distance) * diffY);
        
        //if(y <= 0 || y >= Game.HEIGHT -32) valY *= -1;
        //if(x <= 0 || x >= Game.WIDTH -16) valX *= -1;
        
        handler.addObj(new Trail(x, y, ID.Trail, Color.blue, 16, 16, 0.02f, handler));
            
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)x, (int)y, 16, 16);
    }
     @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16,16);
    }  
}
