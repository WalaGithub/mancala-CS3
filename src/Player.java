import java.util.Scanner;
public class Player {
    final String name;
    final char c;
    final Scanner scanner=new Scanner(System.in);
    public Player(char color){
        c=color;
        System.out.println("Player "+c+" please type your name");
        name=scanner.nextLine();
    }
    public void turnStart(Dice d1, Dice d2){
        System.out.println("Please roll dice");
        d1.canRoll=true;
        try{
            while(d1.canRoll){
                Thread.sleep(10);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thank you");
    }
}
