package InternPe_Project;

import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
                char[][] board = {
                        {' ', ' ', ' '},
                        {' ', ' ', ' '},
                        {' ', ' ', ' '}
                };

                char currentPlayer = 'X';

                boolean gameOver = false;
                int moves = 0;

                while (!gameOver) {
                    printBoard(board);

                    int[] move = getPlayerMove(board, currentPlayer);

                    int row = move[0];
                    int col = move[1];

                    if (board[row][col] == ' ') {
                        board[row][col] = currentPlayer;
                        moves++;

                        if (checkWin(board, currentPlayer)) {
                            printBoard(board);
                            System.out.println("Player " + currentPlayer + " wins!");
                            gameOver = true;
                        } else if (moves == 9) {
                            printBoard(board);
                            System.out.println("It's a draw!");
                            gameOver = true;
                        }

                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    } else {
                        System.out.println("Cell already occupied. Try again.");
                    }
                }
            }

            public static void printBoard(char[][] board) {
                System.out.println("-------------");
                for (int row = 0; row < 3; row++) {
                    System.out.print("| ");
                    for (int col = 0; col < 3; col++) {
                        System.out.print(board[row][col] + " | ");
                    }
                    System.out.println("\n-------------");
                }
            }

            public static int[] getPlayerMove(char[][] board, char player) {
                Scanner scanner = new Scanner(System.in);
                int[] move = new int[2];

                while (true) {
                    System.out.print("Player " + player + ", enter your move (row and column, e.g., 1 2): ");
                    move[0] = scanner.nextInt() - 1;
                    move[1] = scanner.nextInt() - 1;

                    if (move[0] >= 0 && move[0] < 3 && move[1] >= 0 && move[1] < 3) {
                        return move;
                    } else {
                        System.out.println("Invalid input. Please enter row and column within the range 1-3.");
                    }
                }
            }

            public static boolean checkWin(char[][] board, char player) {
                for (int i = 0; i < 3; i++) {
                    if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                        return true;
                    }
                    if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                        return true;
                    }
                }

                if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                    return true;
                }
                if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                    return true;
                }

                return false;
            }
        }

