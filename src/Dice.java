import javax.swing.*;
import java.awt.*;

public class Dice extends JPanel {
    int number, x, y;
    public Dice(int X, int Y){
        number=(int) (Math.random()*6)+1;
        x=X;
        y=Y;
    }
    public void roll(){
        number=(int) (Math.random()*6)+1;
    }
    public void paiut(Graphics window){
        window.setColor(Color.DARK_GRAY);
        window.fillRect(x-35,y-35,70,70);
        window.setColor(Color.LIGHT_GRAY);
        window.fillRect(x-30,y-30,60,60);
        window.setColor(Color.DARK_GRAY);
        window.fillOval(x-35,y-35,70,70);
        window.setColor(Color.LIGHT_GRAY);
        window.fillOval(x-30,y-30,60,60);
        Font dice=new Font("Bodoni MT Black",Font.BOLD,60);
        window.setFont(dice);
        FontMetrics fm= window.getFontMetrics(dice);
        int h=fm.getAscent();
        int w=fm.stringWidth(""+number);
        window.setColor(Color.DARK_GRAY);
        window.drawString(""+number,x-(w/2), (y+(30)-((60-h+fm.getDescent())/2)));
    }
    public int[] getCordinets(){
        return new int[] {x-30,x+30,y-30,y+30};
    }
}