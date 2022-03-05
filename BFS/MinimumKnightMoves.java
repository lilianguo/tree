/**
 * Note: In Java, the HashSet is not the most efficient data structure. For this reason, using the
 * HashSet data structure to keep track of the visited cells in the Java implementation will result
 * in the TLE (Time Limit Exceeded) exception.
 *
 * <p>To avoid the TLE exception, we use a bitmap (i.e. a two-dimentional array of boolean values)
 * instead of a HashSet. The range of the array is set according to the constraint of the input
 * (i.e. ∣x∣+∣y∣<=300|x| + |y| <= 300∣x∣+∣y∣<=300).
 *
 * <p>1197. Minimum Knight Moves Medium
 *
 * <p>In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at
 * square [0, 0].
 *
 * <p>A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a
 * cardinal direction, then one square in an orthogonal direction.
 *
 * <p>Return the minimum number of steps needed to move the knight to the square [x, y]. It is
 * guaranteed the answer exists.
 *
 * <p>Example 1:
 *
 * <p>Input: x = 2, y = 1 Output: 1 Explanation: [0, 0] → [2, 1]
 *
 * <p>Example 2:
 *
 * <p>Input: x = 5, y = 5 Output: 4 Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *
 * <p>Constraints:
 *
 * <p>-300 <= x, y <= 300 0 <= |x| + |y| <= 300
 *
 */
class Solution {
  public int minKnightMoves(int x, int y) {
    int[] dx = new int[] {2, 1, -1, -2, -2, -1, 1, 2};
    int[] dy = new int[] {1, 2, 2, 1, -1, -2, -2, -1};

    Queue<int[]> nexts = new LinkedList<int[]>();
    boolean[][] visited = new boolean[605][605];
    nexts.add(new int[] {0, 0});
    int moves = 0;
    while(!nexts.isEmpty()) {
      int levelSize = nexts.size();
      for (int i = 0; i < levelSize; i++) {
        int[] currLoc = nexts.poll();
        if (currLoc[0] == x && currLoc[1] == y)
          return moves;

        for (int dir = 0; dir < 8; dir++) {
          int[] next = new int[2];
          next[0] = currLoc[0] + dx[dir];
          next[1] = currLoc[1] + dy[dir];
          if (!visited[next[0] + 302][next[1] + 302]) {
            visited[next[0] + 302][next[1] + 302] = true;
            nexts.add(next);
          }

        }
      }
      moves++;
    }
    return moves;
  }
}