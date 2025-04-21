// Given a Tic-Tac-Toe board as a string array board, return true if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

// The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. The ' ' character represents an empty square.

// Here are the rules of Tic-Tac-Toe:

// Players take turns placing characters into empty squares ' '.
// The first player always places 'X' characters, while the second player always places 'O' characters.
// 'X' and 'O' characters are always placed into empty squares, never filled ones.
// The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
// The game also ends if all squares are non-empty.
// No more moves can be played if the game is over.


public class TicTacToeValidator {

    public boolean isValidTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;

        // Count Xs and Os
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }
        }

        boolean xWin = isWinner(board, 'X');
        boolean oWin = isWinner(board, 'O');

        // Rule 1: X starts first and has at most one more move than O
        if (oCount > xCount || xCount > oCount + 1) return false;

        // Rule 2: Both players can't win at the same time
        if (xWin && oWin) return false;

        // Rule 3: If X wins, must be xCount == oCount + 1
        if (xWin && xCount != oCount + 1) return false;

        // Rule 4: If O wins, must be xCount == oCount
        if (oWin && xCount != oCount) return false;

        return true;
    }

    private boolean isWinner(String[] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player &&
                board[i].charAt(1) == player &&
                board[i].charAt(2) == player) return true;

            if (board[0].charAt(i) == player &&
                board[1].charAt(i) == player &&
                board[2].charAt(i) == player) return true;
        }

        // Check diagonals
        if (board[0].charAt(0) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(2) == player) return true;

        if (board[0].charAt(2) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(0) == player) return true;

        return false;
    }

    public static void main(String[] args) {
        TicTacToeValidator validator = new TicTacToeValidator();

        String[] board1 = {"XOX", "O O", "XOX"};
        System.out.println(validator.isValidTicTacToe(board1)); // true

        String[] board2 = {"XXX", "   ", "OOO"};
        System.out.println(validator.isValidTicTacToe(board2)); // false

        String[] board3 = {"XOX", " XO", " XO"};
        System.out.println(validator.isValidTicTacToe(board3)); // false
    }
}




