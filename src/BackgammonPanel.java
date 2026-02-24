import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class BackgammonPanel extends JPanel implements Runnable, MouseListener, KeyListener {


	public BackgammonPanel()
	{

		//DO NOT TOUCH these 3 lines
		//these lines load the listener that listens for the keyboard presses
		addKeyListener( this );   	//
		setFocusable( true );		// Do NOT DELETE these three lines
		addMouseListener(this); //
		new Thread(this).start();	//
	}

	public void paint( Graphics window )// all other paint methods and game logic goes in here.
	{
		window.setColor(Color.BLACK); window.fillRect( 0,0, 1024, 768); // makes the background white
		window.setColor(Color.WHITE); window.drawRect( 0,0, 1024, 768); // draws a black box around the outside

		window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder



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

//            window.setColor(Color.BLACK); window.fillRect( 0,0, 1024, 768); // makes the background white
//            window.setColor(Color.WHITE); window.drawRect( 0,0, 1024, 768); // draws a black box around the outside
//            window.setFont(big);
//            window.drawString("YOU WON",0,200);
//            window.drawString("GOOD JOB",0,400);
//            gameEndW=true;
        }

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void run() {

	}
}