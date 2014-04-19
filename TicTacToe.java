public class TicTacToe {
  private int len;
  private int[][] board;

  public TicTacToe(int size) {
    len = size;
    board = new int[len][len];
  }

  public Character winner() {
    Character winner = rowWinner();
    if (winner != null) return winner;
    winner = colWinner();
    if (winner != null) return winner;
    return diagWinner();
  }

  private Character rowWinner() {
    Character atZero = null;
    for (int row = 0; row < len; row++) {
      atZero = board[row][0];
      for (int col = 1; col < len; col++)
        if (!atZero.equals(board[row][col])) break;
        if (col == len - 1) return atZero;
    }
    return null;
  }

  private Character colWinner() {
    Character atZero = null;
    for (int col = 0; col < len; col++) {
      atZero = board[0][col];
      for (int row = 1; row < len; row++)
        if (!atZero.equals(board[row][col])) break;
        if (row == len - 1) return atZero;
    }
    return null;
  }

  private Character diagWinner() {
    Character atZero = board[0][0];
    for (int row = 1, col = 1; row < len; row++, col++)
      if (!atZero.equals(board[row][col])) break;
      if (row == len - 1) return atZero;
    atZero = board[len-1][0];
    for (int row = len-2, col = 1, col < len; row--, col++)
      if (!atZero.equals(board[row][col])) break;
      if (col == len - 1) return atZero;
    return null;
  }
}
