 
//heads up display

import java.awt.*;

public class HUD {
    
    public static float HEALTH = 100;
    private  float grrenVal = 255;
    private int score = 0;
    private int level =1;
    
    public void tick(){        
        HEALTH= Game.clamp(HEALTH, 0, 100);
        grrenVal = Game.clamp(grrenVal, 0, 255);
        grrenVal = HEALTH*2;
        score++;
    }
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75,(int)grrenVal,0));
       
        g.fillRect(15, 15, (int)HEALTH*2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
        
        g.drawString("Score: "+ score, 15, 64);
        g.drawString("Level: "+ level, 15, 80);
        
    }
    
    public void score(int score){
        this.score = score;
    }
    
    public int getScore(){
         return score;
    }    
      
    public void setLevel(int level){
        this.level = level;
    }
    
    public int getLevel(){
         return level;
    }    
}