/**
 * Given a sorted array of n integers that has been rotated an unknown number of times,
 * write code to find an element in the array. You may assume that the array was originally
 * sorted in increasing order.
 *
 *     Example
 *         Input: find 5 in { 15, 16, 19, 20, 25, 1, 2, 4, 5, 7, 10, 14 }
 *         Output: 8 (index of 5 in the array)
 */
public class FindInRotatedArray<E extends Comparable<E>> {

  /**
   * Finds the index of element in a rotated array, if it exists.
   *
   * @param a the rotated array
   * @param x the element to be searched for
   * @return the index of first match to x, or null if does not exist in array
   */
  public Integer findIndexOf(E[] a, E x) {
    if (x == null) return null;
    Integer[] result = new Integer[1];
    iter(a, x, 0, a.length-1, result);
    return result[0];
  }

  private void iter(E[] a, E x, int from, int to, Integer[] result) {
    int len = to - from + 1;

    // if size is zero or result is found, then stop
    if (result[0] != null) return;

    // if less than 5 elements, then cannot partition into 3 regions
    if (len < 5) {
      for (int i = from; i <= to; i++)
        if (x.equals(a[i])) {
          result[0] = i;
          break;
        }
      return;
    }

    // enough elements to partition subarray into 3 regions
    int third = len / 3;
    int i = from + third;   // left region is bounded by `from` to `i-1`
    int j = to + 1 - third; // middle region bounded by `i+1` to `j-1`
                            // right region bounded by `j+1` to `to`

    // if `a[i]` or `a[j]` matches `x`, then we're done
    if (x.equals(a[i])) {
      result[0] = i;
      return;
    } else if (x.equals(a[j])) {
      result[0] = j;
      return;
    }

    // if `a[i]` < `a[j]` then the middle section is normally ordered
    if (a[i].compareTo(a[j]) < 0) {
      // since the middle section is normally ordered, if `a[i]` < `x` < `a[j]`
      // then the targeted element exists in the middle section
      if (a[i].compareTo(x) < 0 && x.compareTo(a[j]) < 0) {
        iter(a, x, i+1, j-1, result);
      // otherwise, `x` must be in the left or right regions
      } else {
        iter(a, x, from, i-1, result);
        iter(a, x, j+1, to, result);
       }

    // else `a[i]` > `a[j]`, so the inflection point exists within the middle
    } else {
      // since the middle has elements both greater than `a[i]` and less than `a[j]`
      // `x` is in the middle if it is bigger than `a[i]` or less than `a[j]`
      if (a[i].compareTo(x) < 0 || x.compareTo(a[j]) < 0) {
        iter(a, x, i+1, j-1, result);
      // otherwise, `x` must be in the left or right regions
      } else {
        iter(a, x, from, i-1, result);
        iter(a, x, j+1, to, result);
      }
    }
  }
}
