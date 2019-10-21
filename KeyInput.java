 

import java.awt.event.*;

public class KeyInput extends KeyAdapter{

    private Handler handler;
    private boolean[] keyDown = new boolean[4];
    public KeyInput(Handler handler) {
        this.handler=handler;
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        
        for (int i = 0; i < handler.obj.size(); i++) {
             GameObject tmpObj = handler.obj.get(i);
             
             if(tmpObj.getId() == ID.Player)
             {
                 if(key == KeyEvent.VK_W){ tmpObj.setValY(-5); keyDown[0] = true;}
                     
                 if(key == KeyEvent.VK_S){ tmpObj.setValY(5); keyDown[1] = true;}
                 if(key == KeyEvent.VK_D){ tmpObj.setValX(5); keyDown[2] = true;}
                 if(key == KeyEvent.VK_A){ tmpObj.setValX(-5); keyDown[3] = true;}
                 
             }
            
        }
        if(key == KeyEvent.VK_ESCAPE)  System.exit(0);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int key = ke.getKeyCode();
        
        for (int i = 0; i < handler.obj.size(); i++) {
             GameObject tmpObj = handler.obj.get(i);
             
             if(tmpObj.getId() == ID.Player)
             {
                 if(key == KeyEvent.VK_W)  keyDown[0] = false; 
                 if(key == KeyEvent.VK_S)  keyDown[1] = false; 
                 if(key == KeyEvent.VK_D)  keyDown[2] = false; 
                 if(key == KeyEvent.VK_A)  keyDown[3] = false; 

                 //vertical movement
                 if(!keyDown[0] && !keyDown[1]) tmpObj.setValY(0);
                 //horizontal movement
                 if(!keyDown[2] && !keyDown[3]) tmpObj.setValX(0);
             }
          
        }
    }
    
}
