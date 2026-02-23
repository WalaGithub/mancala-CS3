import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class BreakOut extends JPanel implements Runnable, KeyListener {
	private final boolean[] keys; // this stores booleans for when a key is pressed or not.
	//PROCESS EACH ONE OF THESE ONE AT A TIME
	private final Paddle paddle;	// this is the paddle that moves across the bottom of the screen
//	private ArrayList<Ball> balls; // this is the ball that bounces around the screen
    private final ArrayList<Ball> bullets; // this is the ball that bounces around the screen
	private ArrayList< Brick > bricks;// this is the list of bricks that are to be drawn on the screen
//    private ArrayList<centipede> centipedes;
	boolean gameEndL;
	boolean gameEndW;
    private int baaaaaaaaaaaaaaaaaaaaaa;


	public BreakOut()
	{
		setBackground(Color.WHITE);
        baaaaaaaaaaaaaaaaaaaaaa=0;
		keys = new boolean[6];
		paddle=new Paddle(210,510+30,30,30,30);
        bullets = new ArrayList<>();
		bricks=new ArrayList<>();
//        centipedes=new ArrayList<>();
//        centipedes.add(new centipede(6,'L'));
		for(int q=0;q<20;q++){
			bricks.add( new Brick(30*((int) (Math.random()*(924*1.9)/100)), 30*((int) (Math.random()*50/3)),30,30));
		}
		gameEndL=false;
		gameEndW=false;
		//DO NOT TOUCH these 3 lines
		//these lines load the listener that listens for the keyboard presses
		addKeyListener( this );   	//
		setFocusable( true );		// Do NOT DELETE these three lines
		new Thread(this).start();	//
	}

	public void paint( Graphics window )// all other paint methods and game logic goes in here.
	{
		window.setColor(Color.BLACK); window.fillRect( 0,0, 1024, 768); // makes the background white
		window.setColor(Color.WHITE); window.drawRect( 0,0, 1024, 768); // draws a black box around the outside

		window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder
		if(keys[1]) // Left Arrow is pressed
		{
			//move the paddle left
			paddle.moveLeft();
			keys[1] = false;
		}
		if(keys[2]) // Right Arrow is pressed
		{
			//move the paddle right
			paddle.moveRight();
			keys[2] = false;
		}
		for(Brick x:bricks){
//            if(((int) (Math.random() * 2))==0) continue;
			x.paint(window);
		}
		paddle.paint(window);
        if(keys[0]) {
            paddle.shoot();
            bullets.add(paddle.getBullet());
            keys[0]=false;
        }
        if(keys[3]) {
            paddle.moveUp();
            keys[3]=false;
        }
        if(keys[4]) {
            paddle.moveDown();
            keys[4]=false;
        }
        if(keys[5]){
            keys[5]=false;
        }
//        for(centipede c:centipedes){
//            if(baaaaaaaaaaaaaaaaaaaaaa%50==0){
//                c.move(bricks);
//			}
//            c.paint(window);
//        }
        baaaaaaaaaaaaaaaaaaaaaa++;
        try {
            for (Ball bullet : bullets) {
                bullet.paint(window);
//                bullet.bounce();
                boolean cond = false;
                for (Brick x : bricks) {
                    if (bullet.intersects(x)) {
                        bricks.remove(x);
                        cond = true;
                        break;
                    }
                }
                bullet.setX(bullet.getX() + bullet.getxSpeed());
                bullet.setY(bullet.getY() + bullet.getySpeed());
                if (bullet.getY() + (bullet.getH() / 10) + bullet.getH() > 768 || cond) {
                    bullets.remove(bullet);
                }
            }
        } catch (Exception _) {
        }

//		for(Ball ball:balls) {
//			ball.paint(window);
//			//make the Ball move
//			ball.bounce();
//			ball.bouncePaddle(paddle);
//			for (Brick x : bricks) {
//				ball.bounceStuff(x);
//				if (ball.intersects(x)) {
//					bricks.remove(x);
//				}
//			}
//			ball.setX(ball.getX() + ball.getxSpeed());
//			ball.setY(ball.getY() + ball.getySpeed());
//			if(ball.getY()+(ball.getH()/10)+ball.getH()>768){
//				balls.remove(ball);
//			}
//		}
//        Font big=new Font("Big",Font.BOLD,175);
        if(bricks.isEmpty() || gameEndW){
            bricks = new ArrayList<>();
            for(int q=0;q<20;q++){
                bricks.add( new Brick(30*((int) (Math.random()*(924*1.9)/100)), 30*((int) (Math.random()*50/3)),30,30));
            }
//            window.setColor(Color.BLACK); window.fillRect( 0,0, 1024, 768); // makes the background white
//            window.setColor(Color.WHITE); window.drawRect( 0,0, 1024, 768); // draws a black box around the outside
//            window.setFont(big);
//            window.drawString("YOU WON",0,200);
//            window.drawString("GOOD JOB",0,400);
//            gameEndW=true;
        }
	}
	

	// only edit if you would like to add more key functions
	public void keyPressed(KeyEvent e)
	{
		if( e.getKeyCode()  == KeyEvent.VK_SPACE )
		{
			keys[0]=true;
		}
		if( e.getKeyCode()  == KeyEvent.VK_LEFT )
		{
			keys[1]=true;
		}
		if( e.getKeyCode()  == KeyEvent.VK_RIGHT )
		{
			keys[2]=true;
		}
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[3]=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[4]=true;
        }
        if (e.getKeyCode()== KeyEvent.VK_M){
            keys[5]=true;
        }
    }


	// do not edit anything from this point on!!!
	public void keyTyped(KeyEvent e)
	{
		keyPressed( e );			
	}		
	public void keyReleased(KeyEvent e)	{ 	}
	
	public void run()
	{
		try
		{
			while( true )
			{
				if(gameEndL || gameEndW){
					repaint();
					break;
				}
				Thread.sleep( 2 );
				repaint();
			}
		}
		catch( Exception _)
		{			
		}
	}
}