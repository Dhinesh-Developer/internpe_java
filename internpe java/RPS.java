import java.util.Random;
import java.util.Scanner;
public class RPS{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Welcome to rock,paper,scissor");
        System.out.println("Enter your move (rock, paper, or scissors). Type 'exit' to quit.");
        while (true) {
            System.out.print("enter the opition:");
            String userMove = scanner.nextLine().toLowerCase();
            if (userMove.equals("exit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
                System.out.println("Invalid move. Please enter rock, paper, or scissors.");
                continue;
            }
            String[] moves = {"rock","paper","scissor"};
            String computerMove = moves[r.nextInt(moves.length)];
            System.out.println("Complier option: " + computerMove);
            if (userMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if ((userMove.equals("rock") && computerMove.equals("scissors")) ||
                       (userMove.equals("paper") && computerMove.equals("rock")) ||
                       (userMove.equals("scissors") && computerMove.equals("paper"))) {
                System.out.println("You win");
            } else {
                System.out.println("You lose");
            }
        }
        scanner.close();
    }
}

