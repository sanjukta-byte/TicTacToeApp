public class TicTacToeApp {

    // 3x3 board
    static char[][] board = new char[3][3];

    public static void main(String[] args) {

        initializeBoard();
        printBoard();
    }

    // Initialize all cells with '-'
    static void initializeBoard() {

        for (int i = 0; i < 3; i++) {          // rows
            for (int j = 0; j < 3; j++) {      // columns
                board[i][j] = '-';
            }
        }
    }

    // Print the board
    static void printBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // move to next row
        }
    }
}