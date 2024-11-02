package motionCutWork;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {{' ',' ',' '}, {' ', ' ', ' '},{' ',' ',' '}};
    static char curPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            playerMove(scanner);
            gameEnded = checkWinner();
            if (!gameEnded) {
                switchPlayer();
            }
        }

        printBoard();
        System.out.println("GAME OVER!");
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static void playerMove(Scanner scanner) {
        int row = 0;
        int col = 0;
        boolean valMov = false;

        while (!valMov) {
            try {
                System.out.println("Player "+ curPlayer + ", enter your move in terms of rows and columns: ");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = curPlayer;
                    valMov = true;
                } else {
                    System.out.println("This move is not valid");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid integers for row and column.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    public static boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == curPlayer && board[i][1] == curPlayer && board[i][2] == curPlayer) {
                System.out.println("Player "+ curPlayer + " wins!!!");
                return true;
            }
            if (board[0][i] == curPlayer && board[1][i] == curPlayer && board[2][i] == curPlayer) {
                System.out.println("Player "+ curPlayer + " wins!!!");
                return true;
            }
        }
        if (board[0][0] == curPlayer && board[1][1] == curPlayer && board[2][2] == curPlayer) {
            System.out.println("Player "+ curPlayer + " wins!!!");
            return true;
        }
        if (board[0][2] == curPlayer && board[1][1] == curPlayer && board[2][0] == curPlayer) {
            System.out.println("Player "+ curPlayer + " wins!!!");
            return true;
        }

        boolean boardFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    boardFull = false;
                }
            }
        }
        if (boardFull) {
            System.out.println("The game is a tie!");
            return true;
        }
        return false;
    }

    public static void switchPlayer() {
        curPlayer = (curPlayer == 'X') ? 'O' : 'X';
    }
}
