import java.util.Scanner;
public class Player {
//    final String name;
    final char c;
//    final Scanner scanner=new Scanner(System.in);//
    public Player(char color){
        c=color;
        System.out.println("Player "+c+" please type your name");
//        name=scanner.nextLine();
    }
    public void turnStart(Dice d1, Dice d2){
        System.out.println("Please roll dice and hit enter when complete");
        d1.canRoll=true;
//        System.out.println(scanner.nextLine());
        System.out.println("Thank you");
    }
}
