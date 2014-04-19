import scala.collection.mutable.ArrayBuffer

case class TicTacToe(len: Int) {
  private val board = ArrayBuffer.fill[Option[Char]](len,len)(None)

  def move(player: Char, row: Int, col: Int): Unit = ???

  def winner: Option[Char] =
    (rowWinner ++ colWinner ++ diaWinner)
      .filter(_.isDefined)
      .headOption
      .flatten

  private def rowWinner = board.map(winnerOf)

  private def colWinner =
    (0 until len)
      .map(i => board.map(_(i)))
      .map(winnerOf)

  private def diaWinner =
    Seq(
      (0 until len).map(i => board(i)(len-1-i)),
      (0 until len).map(i => board(i)(i))
    ).map(winnerOf)

  private def winnerOf(a: Seq[Option[Char]]): Option[Char] = {
    if(a(0).isDefined && a.distinct.size == 1) a(0)
    else None
  }

  def printBoard: Unit = ???
}
