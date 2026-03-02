import java.awt.*;
import java.util.Stack;
//
public class triangle {
    Stack<Checker> x;
    public triangle(){
        x=new Stack<>();
    }
    public void add(Checker c){
        x.add(c);
    }
    public void paint(Graphics window){
        for(Checker c:x){
            c.paint(window);
        }
    }
}
