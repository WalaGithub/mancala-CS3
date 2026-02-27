import javax.swing.*;
import java.awt.*;

public class Dice extends JPanel {
    int number, x, y;
    public Dice(int X, int Y){
        number=(int) (Math.random()*6)+1;
        int x=X;
        int y=Y;
    }
    public void roll(){
        number=(int) (Math.random()*6)+1;
    }
    public void paiut(Graphics window){
        window.setColor(Color.WHITE);
        window.fillRect(x-30,y-30,60,60);
        Font dice=new Font("Bodoni MT Black",Font.BOLD,60);
        window.setFont(dice);
        FontMetrics fm= window.getFontMetrics(dice);
        int h=fm.getAscent();
        int w=fm.stringWidth(""+number);
        window.setColor(Color.BLACK);
        window.drawString(""+number,x-(w/2), (y+(30)-((60-h+fm.getDescent())/2)));
    }
    public int[] getCordinets(){
        return new int[] {x-30,x+30,y-30,y+30};
    }
}
