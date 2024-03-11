import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        System.out.println("What is the number of Players?");
        Scanner scan = new Scanner(System.in);
        int numOfPlayers = scan.nextInt();

        while(numOfPlayers<2 || numOfPlayers>8){
            System.out.println("Please enter valid number of players");
            numOfPlayers = scan.nextInt();
        }

        GameController game = new GameController(numOfPlayers);
    }
}