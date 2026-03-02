import javax.swing.*;
import java.awt.*;
//
public class Checker extends JPanel {
    char color;
    int x,y;
    public Checker(int ex, int wy, char c){
        x=ex;
        y=wy;
        color=c;
    }
    public void paint(Graphics window) {
        if(color=='w'){
            window.setColor(Color.WHITE);
        }
        else if(color=='b'){
            window.setColor(Color.BLACK);
        }
        window.fillOval(x-22,y-22,55,55);
    }
}
