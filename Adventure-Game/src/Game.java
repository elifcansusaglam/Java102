import java.util.Scanner;

public class Game {
    private Scanner input=new Scanner(System.in);
    void start(){
        System.out.println("--------------------------");
        System.out.println("Welcome to Adventure Game!");
        System.out.println("--------------------------");
        System.out.print("Enter your name : ");
        String playerName=input.nextLine();
        Player player=new Player(playerName);
        System.out.println("Welcome to dessert island "+ player.getName()+" !");
        System.out.println("----------------------------------------------------------------------------------");
        player.selectCharacter();
        player.selectLocation();
    }
}
