/**
* Given a sorted array of n integers that has been rotated an unknown number of times,
* write code to find an element in the array. You may assume that the array was originally
* sorted in increasing order.
*
* Example
* Input: find 5 in { 15, 16, 19, 20, 25, 1, 2, 4, 5, 7, 10, 14 }
* Output: 8 (index of 5 in the array)
*/
object FindInRotatedArray {

  /**
  * Finds the index of element in a rotated array, if it exists.
  *
  */
  def findIndexOf[T](a: Array[T], x: T)(implicit ord: Ordering[T]): Option[Int] = {
    import ord._
    def iter(low: Int, high: Int): Seq[Int] = {
      val len = high - low + 1
      if (len < 5) 
        for { 
          i <- low to high
          if a(i) == x
        } yield i
      else {
        val third = len / 3
        (low + third, high + 1 - third) match {
          case (i,_) if a(i) == x => Seq(i)
          case (_,j) if a(j) == x => Seq(j)
          case (i,j) if (a(i) < x && x < a(j)) ||
                        (a(i) > a(j) && (a(i) < x || x < a(j))) => iter(i+1, j-1)
          case (i,j) => iter(low,i-1) ++ iter(j+1,high)
        }
      }
    }
    iter(0,a.size-1).headOption
  }
  
  val arr = Array(11, 11, 15, 15, 19, 24, 26, 31, 31, 32, 34, 36, 36, 38, 
                  40, 41, 41, 47, 1, 1, 1, 1, 5, 6, 8, 8, 8, 10)
}
