import java.awt.*;

public class Paddle extends Brick {
	private int speed; // a paddle has to have a speed to make it move
    private Ball bullet;
    private int width;
	
	public Paddle( int ex, int wy, int wd, int ht, int sp) {
		//write the code for the Paddle constructor
		//must have a super constructor call
		//super call must be first
		super(ex,wy,wd,ht);
        width=wd;
		speed=sp;
	}
	
	public void moveLeft() {
		if(getX()<=0){
			setX(0);
		}
		else{
			setX(getX()-speed); // because a paddle is a block it has the setX and getX methods
		}
	}

	public void moveRight() {
		if(getX()>=558-getW()){
			setX(558-getW());
		}
		else{
			setX(getX()+speed);
		}
	}	
	
	//overidde paint to draw your Paddle
	public void paint( Graphics window )
	{
		//Draw the Paddle with graphics methods
		window.setColor(Color.WHITE);
//		window.fillRect(getX(), getY(), width, getH());
        Image pad=Toolkit.getDefaultToolkit().getImage("cursor.png");
        window.drawImage(pad, getX()+(width/2)/30*30-30, getY()-(getH()/2)/30*30, width, getH(), this);
	}

    public void shoot() {
        int ballsize = 56;
        int ballw=10;
        bullet = new Ball(getX()-(ballw),getY(),ballw,ballsize,-10);
//        bullet.paint(window);
//			//make the Ball move
//			bullet.bounce();
//			bullet.bouncePaddle(paddle);
//			for (Brick x : bricks) {
//				bullet.bounceStuff(x);
//				if (bullet.intersects(x)) {
//					bricks.remove(x);
//				}
//			}
//			bullet.setX(bullet.getX() + bullet.getxSpeed());
//			bullet.setY(bullet.getY() + bullet.getySpeed());
    }

    public Ball getBullet() {
        return bullet;
    }

    public void moveUp() {
        if(getY()>=720-getW()){
            setY(500+getW());
        }
        else{
            setY(getY()-speed);
        }
    }

    public void moveDown() {
        if(getY()>=720-getW()){
            setY(720-getW());
        }
        else{
            setY(getY()+speed);
        }
    }
}