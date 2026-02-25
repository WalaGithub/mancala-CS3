import java.awt.*;
//
public class Checker extends Hitbox {
    char color;
    public Checker(int ex, int wy, int wd, int ht, int sp,char c){
        super(ex, wy, wd, ht);
        color=c;
    }
}
  /*
    /*public void bouncePaddle(Paddle o){
        double midX=getX()+ getW()/2;
        double midXo=o.getX()+o.getW()/2;
        if(intersects(o)){
            ySpeed=-ySpeed;
            double xsp=midX-midXo;
            int fob;
            if(midX>=midXo){
                fob=1;
            }
            else{
                fob=-1;
            }
//            if(xsp>=-10 && xsp<=10){
//                xSpeed=0;
//            }
//            else if(xsp>=-70 && xsp<=70){
//                xSpeed=fob;
//            }
//            else if(xsp>=-150 && xsp<=150){
//                xSpeed=2*fob;
//            }
//            else{
//                xSpeed=3 *fob;
//            }
        }
    }*/
//  public void paint(Graphics window) {
//      window.setColor(Color.ORANGE);
//      int x=0;
//        int y=getY();
//        int h=getH();
//        int w=getW();
//        Image baguette=Toolkit.getDefaultToolkit().getImage("boulet.png");
//        window.drawImage(baguette, x+(w/2)/30*15-10, y-(h/2)/30*15-30-15, w, h, this);
//        window.fillOval(x,y+(h/10),w,h);
//        window.setColor(Color.BLACK);
//        window.fillOval((x+w/2)-w/5,15*(h/50)+y,(6*(w/50)),(15*(h/50)));
//        window.fillOval((x+w/2)+4*((w/50)),15*(h/50)+y,(6*(w/50)),(15*(h/50)));
//        window.fillArc((x+w/2)-15*(w/50),27*(h/50)+y,3*w/5,26*(h/50),0,-180);
//        window.fillArc((x+w/2)-2*w/5,29*(h/50)+y,2*w/5,h/5,30,-200);
//        window.fillArc((x+w/2),29*(h/50)+y,2*w/5,h/5,150,200);

//        Color LIGHT_BLUE = new Color(140,160,200);
//        Color LIGHT_BLUE1 = new Color(126,144,180);
//        Color DARK_BLUE = new Color(70,80,100);
//        window.setColor(LIGHT_BLUE);
//        window.fillArc((x+w/2)-25*(w/50),h/10+y,w,15*(h/50),-20,220);
//        window.fillOval((x+w/2)-w/10,115*(h/500)+y,w/5,5*(h/50));
//        window.setColor(LIGHT_BLUE1);
//        window.fillOval((x+w/2)-25*(w/50),125*(h/500)+y,w,5*(h/50));
//        window.setColor(DARK_BLUE);
//        window.fillOval((x+w/2)-w/10,38*(h/500)+y,w/5,2*(h/50));
 // }
//}
