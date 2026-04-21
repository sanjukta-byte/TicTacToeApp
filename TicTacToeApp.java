import java.util.Random;
import java.util.Scanner;

public class TicTacToeApp {

    static char[][] board = new char[3][3];

    static char player1Symbol;
    static char player2Symbol;
    static int currentPlayer;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        initializeBoard();
        performToss();
        printBoard();

        int slot = getUserInput();          // UC3
        int[] pos = convertSlotToIndex(slot); // UC4

        int row = pos[0];
        int col = pos[1];

        // 🎯 UC5: Validate move
        if (isValidMove(row, col)) {
            System.out.println("Move is valid.");
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }

    // UC1
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC2
    static void performToss() {
        Random random = new Random();
        int toss = random.nextInt(2);

        if (toss == 0) {
            currentPlayer = 1;
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = 2;
            player2Symbol = 'X';
            player1Symbol = 'O';
        }

        System.out.println("Toss Result:");
        System.out.println("Player " + currentPlayer + " starts first");
        System.out.println("Player 1 Symbol: " + player1Symbol);
        System.out.println("Player 2 Symbol: " + player2Symbol);
    }

    // UC3
    static int getUserInput() {
        System.out.print("Enter a slot number (1-9): ");
        return scanner.nextInt();
    }

    // UC4
    static int[] convertSlotToIndex(int slot) {
        int index = slot - 1;
        int row = index / 3;
        int col = index % 3;
        return new int[]{row, col};
    }

    // 🎯 UC5: Validate row/col and empty cell
    static boolean isValidMove(int row, int col) {

        // Boundary check (0–2)
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Cell must be empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }
}