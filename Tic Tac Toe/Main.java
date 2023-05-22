import java.util.Scanner;

class TicTacToe {
    private static final char P1_CHAR = 'X';
    private static final char P2_CHAR = 'Y';
    private char[][] board = new char[3][3];
    private boolean isP1Turn;
    private GameState gameState;
    private int moves;

    private enum Position {
        P1(0, 0),
        P2(0, 1),
        P3(0, 2),
        P4(1, 0),
        P5(1, 1),
        P6(1, 2),
        P7(2, 0),
        P8(2, 1),
        P9(2, 2);

        private final int x;
        private final int y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getPositionX() {
            return this.x;
        }

        public int getPositionY() {
            return this.y;
        }
    }

    enum GameState {
        P1_WIN,
        P2_WIN,
        RUNNING,
        DRAW
    }

    TicTacToe() {
        isP1Turn = true;
        gameState = GameState.RUNNING;
        moves = 0;
        setInitialBoard();
    }

    private void setInitialBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void move(String pos) {
        try {
            int row = Position.valueOf(pos).getPositionX();
            int col = Position.valueOf(pos).getPositionY();

            if (board[row][col] != '-') {
                System.out.println("Invalid Position");
                return;
            }

            if (isP1Turn) {
                board[row][col] = P1_CHAR;
                moves++;
                updateGameState();
            } else {
                board[row][col] = P2_CHAR;
                moves++;
                updateGameState();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid position");
        }
    }

    private void updateGameState() {
        if (isP1Turn)
            isP1Turn = false;
        else
            isP1Turn = true;

        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X' ||
                board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X' ||
                board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X' ||
                board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X' ||
                board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X' ||
                board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X' ||
                board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X' ||
                board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            gameState = GameState.P1_WIN;
        } else if (board[0][0] == 'Y' && board[0][1] == 'Y' && board[0][2] == 'Y' ||
                board[1][0] == 'Y' && board[1][1] == 'Y' && board[1][2] == 'Y' ||
                board[2][0] == 'Y' && board[2][1] == 'Y' && board[2][2] == 'Y' ||
                board[0][0] == 'Y' && board[1][0] == 'Y' && board[2][0] == 'Y' ||
                board[0][1] == 'Y' && board[1][1] == 'Y' && board[2][1] == 'Y' ||
                board[0][2] == 'Y' && board[1][2] == 'Y' && board[2][2] == 'Y' ||
                board[0][0] == 'Y' && board[1][1] == 'Y' && board[2][2] == 'Y' ||
                board[0][2] == 'Y' && board[1][1] == 'Y' && board[2][0] == 'Y') {
            gameState = GameState.P2_WIN;
        } else if (moves == 9) {
            gameState = GameState.DRAW;
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public boolean isP1Turn() {
        return isP1Turn;
    }

    public GameState getGameState() {
        return gameState;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Need to work on the draw condition: -_-!");
        System.out.println("Use positions: P1 P2 P3 P4 P5 P6 P7 P8 P9");
        Scanner sc = new Scanner(System.in);

        TicTacToe ticTacToe = new TicTacToe();

        while (ticTacToe.getGameState() == TicTacToe.GameState.RUNNING) {
            ticTacToe.displayBoard();

            if (ticTacToe.isP1Turn())
                System.out.println("P1 enter position: ");
            else
                System.out.println("P2 enter position: ");

            String pos = sc.next();
            ticTacToe.move(pos);
        }

        ticTacToe.displayBoard();

        if (ticTacToe.getGameState() == TicTacToe.GameState.P1_WIN)
            System.out.println("P1 Wins!");
        else if (ticTacToe.getGameState() == TicTacToe.GameState.P2_WIN)
            System.out.println("P2 Wins!");
        else
            System.out.println("Draw!");

        sc.close();
    }
}
