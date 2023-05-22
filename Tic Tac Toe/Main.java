import java.util.Scanner;

class TicTacToe {
    private static final char p1Char = 'X';
    private static final char p2Char = 'Y';
    char[][] board = new char[3][3];
    private int gameState;
    private boolean isP1Turn;

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

    TicTacToe(String p1) {
        gameState = 3;
        isP1Turn = true;
        setInitialBoard();
    }

    TicTacToe(String p1, String p2) {
        gameState = 3;
        isP1Turn = true;
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
        if (isP1Turn) {
            board[Position.valueOf(pos).getPositionX()][Position.valueOf(pos).getPositionY()] = p1Char;
            updateGameState();
        } else {
            board[Position.valueOf(pos).x][Position.valueOf(pos).y] = p2Char;
            updateGameState();
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
            gameState = 1;
        } else if (board[0][0] == 'Y' && board[0][1] == 'Y' && board[0][2] == 'Y' ||
                board[1][0] == 'Y' && board[1][1] == 'Y' && board[1][2] == 'Y' ||
                board[2][0] == 'Y' && board[2][1] == 'Y' && board[2][2] == 'Y' ||
                board[0][0] == 'Y' && board[1][0] == 'Y' && board[2][0] == 'Y' ||
                board[0][1] == 'Y' && board[1][1] == 'Y' && board[2][1] == 'Y' ||
                board[0][2] == 'Y' && board[1][2] == 'Y' && board[2][2] == 'Y' ||
                board[0][0] == 'Y' && board[1][1] == 'Y' && board[2][2] == 'Y' ||
                board[0][2] == 'Y' && board[1][1] == 'Y' && board[2][0] == 'Y') {
            gameState = 2;
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

    public int getGameState() {
        return gameState;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Need to work on the draw condition: -_-!");
        System.out.println("Use positions: P1 P2 P3 P4 P5 P6 P7 P8 P9");
        Scanner sc = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe("A", "B");

        while (ticTacToe.getGameState() == 3) {
            ticTacToe.displayBoard();
            if (ticTacToe.isP1Turn())
                System.out.println("P1 enter position: ");
            else
                System.out.println("P2 enter position: ");
            String pos = sc.next();
            ticTacToe.move(pos);
        }
        ticTacToe.displayBoard();
        if (ticTacToe.getGameState() == 1)
            System.out.println("P1 Wins!");
        else if (ticTacToe.getGameState() == 2)
            System.out.println("P2 Wins!");
        else
            System.out.println("Draw!");
    }
}
