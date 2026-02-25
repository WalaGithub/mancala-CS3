import javax.swing.*;
import java.awt.*;

public class Dice extends JPanel {
    int number;
    public Dice(){
        number=(int) (Math.random()*6)+1;
    }
    public void roll(){
        number=(int) (Math.random()*6)+1;
    }
    public void paiut(Graphics window, int x, int y){
        window.setColor(Color.WHITE);
        window.fillRect(x-15,y-15,30,30);
        Font dice=new Font("Bodoni MT Black",Font.BOLD,30);
        window.setFont(dice);
        FontMetrics fm= window.getFontMetrics(dice);
        int h=fm.getAscent();
        int w=fm.stringWidth(""+number);
        window.setColor(Color.BLACK);
        window.drawString(""+number,x-(w/2), (y+(15)-((30-h)/2)));
        window.drawRect(10,(y+15),10000000,1);
        window.drawRect(10,(y+15-(h/2)),10000000,1);
    }
}
