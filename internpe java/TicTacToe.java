import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    private static char currentPlayer = 'X';
    private static final int SIZE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            playerMove(scanner);
            gameEnded = checkForWin() || checkForDraw();
            if (!gameEnded) {
                switchPlayer();
            }
        }

        printBoard();
        if (checkForWin()) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("The game is a draw!");
        }
        scanner.close();
    }

    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println("---------");
            }
        }
    }

    private static void playerMove(Scanner scanner) {
        int row, col;

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid.");
            }
        }
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkForWin() {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    private static boolean checkForDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

