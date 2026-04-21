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

        int slot = getUserInput();   // 🔹 UC3
        System.out.println("You selected slot: " + slot);
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

    // 🎯 UC3: Get user slot input
    static int getUserInput() {

        System.out.print("Enter a slot number (1-9): ");
        int slot = scanner.nextInt();

        return slot;   // requirement: return the value
    }
}