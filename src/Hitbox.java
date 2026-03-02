import java.awt.*;
//
/*
 *	Complete the Brick class.
 *  Use ClassTester to test your code.
 *
 */
public class Hitbox extends Canvas {
	//these are instance variables
	int x, y, w, h;
	public Hitbox() {
		x=437;
		y=364;
		w=100;
		h=30;
	}
	public Hitbox(int ex, int wy, int wd, int ht) {
		x=ex;
		y=wy;
		w=wd;
		h=ht;
	}

	//code to draw the Brick will go here
	public void paint( Graphics window ) {
		//Draw the Brick with Graphics methods
		//or use an Image
//		Color brickRed=new Color(110,150,120);
//		window.setColor(brickRed);
//		window.fillRect(getX(), getY(), getW(), getH());
//		window.setColor(Color.WHITE);
//		window.drawRect(getX(), getY(), getW(), getH());

        Image baguette=Toolkit.getDefaultToolkit().getImage("pad.png");
        window.drawImage(baguette, x+(w/2)/30*30, y-(h/2)/30*30, w, h, this);
	}
}