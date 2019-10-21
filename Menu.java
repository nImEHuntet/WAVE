 

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Menu extends MouseAdapter{
    private Game game;
    private Handler handler;
    private HUD hud; 
    private Random r = new Random();
    
    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if(game.gameState== Game.STATE.Menu){
            //play button
            if(mouseOver(mx, my, 210, 150, 200, 64)){
                game.gameState =  Game.STATE.Game;
                
                handler.addObj(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));   
                handler.clearEnemy(); //so that animation stops of first screen                    
                handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy,handler));
            }
            //help button
            if(mouseOver(mx, my, 210, 250, 200, 64)){
                game.gameState =  Game.STATE.Help;
            }
       //quit button   
        if(mouseOver(mx, my, 210, 350, 200, 64)){
            System.exit(1);
        }
        
     }
         
    //back button for help  
    if(game.gameState == Game.STATE.Help){
     if(mouseOver(mx, my, 210, 350, 200, 64)){
         game.gameState = Game.STATE.Menu;
         return;
     }}

    //back button for help  
    if(game.gameState == Game.STATE.End){
     if(mouseOver(mx, my, 210, 350, 200, 64)){
         game.gameState = Game.STATE.Game;
         hud.setLevel(1);
         hud.score(0);
            
         handler.addObj(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));   
         handler.clearEnemy(); //so that animation stops of first screen                    
         handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy,handler));
     }     
    }   
}
    @Override
    public void mouseReleased(MouseEvent e) {
    
    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            } else return false;
        } else return false;
    }
    public void tick() {
    
    }
    Font fnt =  new Font("arial",1,50);
    Font fnt1 =  new Font("arial",1,20);

    public void render(Graphics g) {
     if(game.gameState == Game.STATE.Menu){      
       
       g.setFont(fnt);
       g.setColor(Color.white);
       g.drawString("Wave", 250, 70);
       
       g.setFont(fnt1);
       g.drawRect(210, 150, 200, 64);
       g.drawString("Play", 270, 190);       
       
       g.drawRect(210, 250, 200, 64);
       g.drawString("Help", 270, 290);
       
       g.drawRect(210, 350, 200, 64);
       g.drawString("Quit...", 270, 390);
       }
    else if(game.gameState == Game.STATE.Help){       
       
       g.setFont(fnt);
       g.setColor(Color.white);
       g.drawString("Help", 240, 70);       
       
       g.setFont(fnt1);
       g.drawString("Use WASD keys to move the player and dodge enemies", 100, 100);
       g.drawString("MoveCloser to green waves for gaining health ",100,150);
       g.drawRect(210, 350, 200, 64);
       g.drawString("BACK", 270, 390);       
    }
     else if(game.gameState == Game.STATE.End){       
       
       g.setFont(fnt);
       g.setColor(Color.white);
       g.drawString("gAmE oVeR", 180, 70);       
       
       g.setFont(fnt1);
       g.drawString("U lost with a score of "+ hud.getScore() , 175, 200);
       g.drawRect(210, 350, 200, 64);
       g.drawString("Try again", 245, 390);       
    }
    }
    
}
