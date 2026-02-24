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
		int w = getWidth();
		int h = getHeight();
		int mar = 30;
		int fr = 35;
		int barW = 70;
		window.setColor(new Color(110, 60, 30));
		window.fillRect(mar, mar, w - 2 * mar, h - 2 * mar);
		int inX = mar+fr;
		int inY = mar+fr;
		int offW = 140;
		int inW = w-2*(mar+fr)-offW;
		int offX = inX+inW;
		int inH = h-2*(mar+fr);

		window.setColor(new Color(170, 140, 90));
		window.fillRect(inX, inY, inW, inH);

		int midX = inX + (inW - barW) / 2;
		window.setColor(new Color(90, 50, 25));
		window.fillRect(midX, inY, barW, inH);
//
		window.setColor(new Color(80, 45, 25));
		window.fillRect(offX, inY, offW, inH);

		window.setColor(Color.BLACK);
		window.drawRect(offX,inY,offW,inH);
		window.drawLine(offX, inY, offX, inY + inH);

		int hal = inH /2;
		int pH = (int) ((int) hal*.90);
		int pW = (inW-barW) /12;
		for (int i = 0; i < 12; i++) {
			int topX;
			if(i<6) {
				topX = inX+i*pW;
			} else topX = inX+barW+i*pW;
			Color c = (i%2==0)?new Color(120,80,45):new Color(235,230,210);
			window.setColor(c);
			fillTriangle(window,topX,inY,pW,pH,false);
			fillTriangle(window, topX, inY + inH, pW, pH, true);
		}
		window.setColor(Color.BLACK);
		window.drawRect(mar,mar,w-2*mar,h-2*mar);

        }

	private void fillTriangle(Graphics window, int x, int bY, int w, int h, boolean up) {
		int[] xs = {x, x + w, x + w / 2};
		int[] ys;
		if (up) {
			ys = new int[]{bY, bY, bY - h};
		} else {
			ys = new int[]{bY,bY,bY+h};
		}
		window.fillPolygon(xs,ys,3);
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