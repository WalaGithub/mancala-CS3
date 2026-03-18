import javax.swing.*;
import java.awt.*;

public class Dice extends JPanel {
    int number, x, y;
    boolean canRoll;
    boolean used;
    public boolean doubdoub;
    public Dice(int X, int Y){
        number=(int) (Math.random()*6)+1;
        x=X;
        y=Y;
        canRoll=true;
        used = false;
    }
    public void roll(){
        number = (int)(Math.random()*6)+1;
        used = false;
    }

    public boolean isDouble() {
        return doubdoub;
    }
    public void paiut(Graphics window){
        Color bg = used ? new Color(100, 100, 100) : Color.LIGHT_GRAY;
        Color fg = used ? new Color(60, 60, 60) : Color.DARK_GRAY;
        window.setColor(fg);
        window.fillOval(x-35,y-35,70,70);
        window.setColor(bg);
        window.fillOval(x-30,y-30,60,60);
        if (!used) {
            Font dice=new Font("Bodoni MT Black",Font.BOLD,60);
            window.setFont(dice);
            FontMetrics fm= window.getFontMetrics(dice);
            int h=fm.getAscent();
            int w=fm.stringWidth(""+number);
            window.setColor(Color.DARK_GRAY);
            window.drawString(""+number,x-(w/2), (y+(30)-((60-h+fm.getDescent())/2)));

        }
            }
    public int[] getCordinets(){
        return new int[] {x-30,x+30,y-30,y+30};
    }
}