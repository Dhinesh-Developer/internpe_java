import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = '.';
    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';
    private char[][] board = new char[ROWS][COLS];

    public ConnectFour() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = EMPTY;
            }
        }
    }
    public void printBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6"); 
    }

    public boolean dropDisc(int col, char player) {
        if (col < 0 || col >= COLS) return false;

        for (int r = ROWS - 1; r >= 0; r--) {
            if (board[r][col] == EMPTY) {
                board[r][col] = player;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char player) {
        return checkHorizontal(player) || checkVertical(player) || checkDiagonal(player);
    }
    private boolean checkHorizontal(char player) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (board[r][c] == player && board[r][c + 1] == player &&
                    board[r][c + 2] == player && board[r][c + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkVertical(char player) {
        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < ROWS - 3; r++) {
                if (board[r][c] == player && board[r + 1][c] == player &&
                    board[r + 2][c] == player && board[r + 3][c] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkDiagonal(char player) {
        for (int r = 0; r < ROWS - 3; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (board[r][c] == player && board[r + 1][c + 1] == player &&
                    board[r + 2][c + 2] == player && board[r + 3][c + 3] == player) {
                    return true;
                }
            }
        }
        for (int r = 3; r < ROWS; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (board[r][c] == player && board[r - 1][c + 1] == player &&
                    board[r - 2][c + 2] == player && board[r - 3][c + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER1;
        boolean gameWon = false;
        while (!gameWon) {
            game.printBoard();
            System.out.println("Player " + (currentPlayer == PLAYER1 ? "1" : "2") + ", enter column (0-6): ");
            int col = scanner.nextInt();

            if (game.dropDisc(col, currentPlayer)) {
                if (game.checkWin(currentPlayer)) {
                    game.printBoard();
                    System.out.println("Player " + (currentPlayer == PLAYER1 ? "1" : "2") + " wins!");
                    gameWon = true;
                } else {
                    currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
                }
            } else {
                System.out.println("Column full or invalid. Try again.");
            }
        }
        scanner.close();
    }
}