
import java.awt.*;
public class Collectable extends GameObject
{
    private Handler handler;
    public static int x; public static int y;
    public Collectable( int  x, int y ,ID id,Handler handler)
    {
        
    super(x,y,id);
    this.handler=handler;
    valX=2;valY=2;
    }
    public void tick()
    {
        x += valX;
        y += valY;
        
        //if(y <= 0 || y >= Game.HEIGHT -32) valY *= -1;
        //if(x <= 0 || x >= Game.WIDTH -16) valX *= -1;
        
        handler.addObj(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.02f, handler));
    }
    public void render(Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect((int) x,(int) y,25,25);
        
    }
     private void collision(){
        
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16,16);
    }  
    
    
}
