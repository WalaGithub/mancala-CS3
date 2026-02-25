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
	// All Bricks will have all of these set and get methods
	//these methods are complete
	public int getX( ){
		return x;
	}
	public void setX( int ex ){
		x = ex;
	}
	public int getY( ){
		return y;
	}
	public void setY( int wy ){
		y = wy;
	}
	public int getW(){
		return w;
	}
	public int getH(){
		return h;
	}
	
	//code to see if this Brick intersects with the other Brick goes here
	public boolean intersects( Hitbox other ) {
		/* Easy Way:
		 * 		Copy and Paste the following URL in Google Chrome mm
		 *		https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html
		 *		make new Rectangle, using this Brick's x,y,w,h
		 *		make new Rectangle, using the other Bricks's x,y,w,h
		 *		return if the two Rectangles intersect, use the Rectangle's intersects method.
		 */
		Rectangle a=new Rectangle(x,y,w,h);
		Rectangle b=new Rectangle(other.getX(),other.getY(),other.getW(),other.getH());
		return a.intersects(b);
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

        Image baguette=Toolkit.getDefaultToolkit().getImage("mushroom_1.png");
        window.drawImage(baguette, x+(w/2)/30*30, y-(h/2)/30*30, w, h, this);
	}
}