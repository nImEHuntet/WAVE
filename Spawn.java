 import java.util.Random;

public class Spawn {

private Handler handler;
private HUD hud;
Random r = new Random();
private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep++;
        
        if(scoreKeep >= 250){
            scoreKeep=0;
            hud.setLevel(hud.getLevel()+1);
            
            /*if(hud.getLevel() ==2){
                handler.addObj(new EnemyBoss(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.EnemyBoss, handler));
            }*/
            
            if(hud.getLevel() ==2){
                 handler.addObj(new BasicEnemy((Game.WIDTH)-50,r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
            }
            else if(hud.getLevel() ==3){
                handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));              
            }
            else if(hud.getLevel() ==4){
                handler.addObj(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));              
            }
            else if(hud.getLevel() ==5){
                handler.addObj(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
            }
             
            else if(hud.getLevel() ==7){
                 
            
                handler.addObj(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
            }
            else if(hud.getLevel() ==8){
                 
            
                handler.addObj(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
            }
            else if(hud.getLevel() ==9){
                 
                 handler.addObj(new Collectable(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.Collect,handler));
              handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.BasicEnemy,handler));
            
                handler.addObj(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
            }
            else if(hud.getLevel() ==10){
                 
            handler.clearEnemy();
                handler.addObj(new EnemyBoss((int)(Game.WIDTH/2)+48, (int)-120,ID.BasicEnemy, handler));
            }
            
            else if(hud.getLevel()==14)
            {
                handler.clearEnemy();
                handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler)); 
                handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler)); 
                handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler)); 
                
                handler.addObj(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
                handler.addObj(new Collectable(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.Collect,handler));
            }
             if(hud.getLevel()==16)
            {
                handler.clearEnemy();
                handler.addObj(new FastEnemy((Game.WIDTH-50), (Game.HEIGHT-50), ID.FastEnemy, handler));
                 handler.addObj(new FastEnemy(0, (Game.HEIGHT-50), ID.FastEnemy, handler));
            }
            
            else if(hud.getLevel()==18)
            {
               
                handler.addObj(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
                handler.addObj(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
            }
            else if(hud.getLevel()==20)
            {
                handler.clearEnemy();
                handler.addObj(new BasicEnemy(0,0,ID.BasicEnemy,handler));
                handler.addObj(new BasicEnemy(0,(Game.HEIGHT-50),ID.BasicEnemy,handler));
                handler.addObj(new BasicEnemy((Game.WIDTH-50),0,ID.BasicEnemy,handler));
                handler.addObj(new BasicEnemy((Game.WIDTH-50),(Game.HEIGHT-50),ID.BasicEnemy,handler));
                
                
            }
            if(hud.getLevel()==25)
            handler.addObj(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.FastEnemy,handler));
            if(hud.getLevel()==28)
            {
                handler.clearEnemy();
                handler.addObj(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.FastEnemy,handler));
                handler.addObj(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.FastEnemy,handler));
                handler.addObj(new SuperFastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.SuperFastEnemy,handler));
            }
            
          
            }
            
            }
        }
    