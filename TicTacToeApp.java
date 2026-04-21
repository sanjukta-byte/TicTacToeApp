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

        int slot = getUserInput();   // UC3

        int[] position = convertSlotToIndex(slot);  // 🎯 UC4
        int row = position[0];
        int col = position[1];

        System.out.println("Converted Position → Row: " + row + ", Column: " + col);
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

    // 🎯 UC4: Convert slot to row & column (0-based)
    static int[] convertSlotToIndex(int slot) {

        // Convert 1–9 → 0–8 first
        int index = slot - 1;

        int row = index / 3;   // division → row
        int col = index % 3;   // modulo → column

        return new int[]{row, col};
    }
}