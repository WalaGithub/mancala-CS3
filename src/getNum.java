import java.util.*;
public class getNum {
    Scanner keyboard = new Scanner( System.in );
    private int numm;
    public getNum(String question){
        System.out.println(question);
        numm= keyboard.nextInt();
    }

    public int getNumm() {
        return numm;
    }
}
