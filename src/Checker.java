import java.awt.*;
//
public class Checker extends Hitbox {
    char color;
    public Checker(int ex, int wy, int wd, int ht, int sp,char c){
        super(ex, wy, wd, ht);
        color=c;
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
 public void paint(Graphics window) {
//
}
}
