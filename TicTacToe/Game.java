package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private final char[][] board;
    private final Player[] players;
    private int currentPlayerIndex;
    private int previousPlayerIndex;

    public Game(){
        board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        players = new Player[]{new Player('O'), new Player('X')};
        currentPlayerIndex = 0;
        previousPlayerIndex = 1;
    }

    public void start(){
        while (!gameIsOver()){

            printBoardOnConsole();

            Player currentPlayer = players[currentPlayerIndex];
            int move = getMove(currentPlayer);

            // If current player gives index 9, it's going to be calculated as (index - 1), so it will be 8.
            // Then board indexes will look like this:
            // board[8/3][8%3] == board[2][2] -> therefore the player will put their symbol on the last board index.
            board[move/3][move%3] = currentPlayer.getSymbol();

            previousPlayerIndex = currentPlayerIndex;

            // Incrementing current player index and doing modulo operation to be sure that value is either 0 or 1 only.
            // players.length = 2; So it's either (0 modulo 2 == 0) or (1 modulo 2 == 1).
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;

        }

        Player winner = getWinner();
        printBoardOnConsole();
        if (winner != null){
            System.out.println("\nPlayer " + winner.getSymbol() + " wins!");
        }
        else {
            System.out.println("\nDraw!");
        }
    }

    private void printBoardOnConsole() {
        for (int i = 0; i < board.length; i++) {
            if (i != 0){
                System.out.println("------------");
            }

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j != 2){
                    System.out.print("|");
                }

            }
            System.out.println(); // move cursor to next row of the "board" array.
        }
    }

    private Player getWinner() {
        // Check if there is a winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return players[previousPlayerIndex];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return players[previousPlayerIndex];
            }
            if (board[i][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != ' ' && board[i][0] != ' ') {
                return players[previousPlayerIndex];
            }
            if (board[i][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ' && board[0][2] != ' ' && board[i][0] != ' ') {
                return players[previousPlayerIndex];
            }
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
                return players[previousPlayerIndex];
            }
        }

        return null;
    }

    private int getMove(Player currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        int move;
        do {
            System.out.println("\nGive index of place where you want to move (1-9).");
            System.out.print("Player " + currentPlayer.getSymbol() + " is moving: ");
            move = scanner.nextInt() - 1;

            if (board[move/3][move%3] == 'O'){
                System.out.println("This index is already taken by 'O'!");
            }
            if (board[move/3][move%3] == 'X') {
                System.out.println("This index is already taken by 'X'!");
            }
        }while (move < 0 || move > 8 || board[move/3][move%3] != ' ');
        return move;
    }

    private boolean gameIsOver() {
        // Check if there is a winner
        Player winner = getWinner();
        if (winner == players[previousPlayerIndex] || winner != null){
            return true;
        }

        // Check if board is empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
