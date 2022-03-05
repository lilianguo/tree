/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

/**
 * 687. Longest Univalue Path Medium
 *
 * <p>Given the root of a binary tree, return the length of the longest path, where each node in the
 * path has the same value. This path may or may not pass through the root.
 *
 * <p>The length of the path between two nodes is represented by the number of edges between them.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [5,4,5,1,1,5] Output: 2
 *
 * <p>Example 2:
 *
 * <p>Input: root = [1,4,5,4,4,5] Output: 2
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [0, 104]. -1000 <= Node.val <= 1000 The depth
 * of the tree will not exceed 1000.
 */
class Solution {

  /**
   *

   Time Complexity: O(N), where NNN is the number of nodes in the tree. We process every node once.

   Space Complexity: O(H), where HHH is the height of the tree. Our recursive call stack could be up to HHH layers deep.

   * @param root
   * @return
   */

  public int longestUnivaluePath(TreeNode root) {
    int[] max = new int[1];
    dfs(root, max);
    return max[0];
  }

  // max is current max univalue path len
  // dfs return the longest path extending from root node in one direction, either left or right;
  private int dfs(TreeNode root, int[] max) {
    if (root == null) return 0;
    int currVal = root.val;
    int currLen = 0;
    int leftVal = dfs(root.left, max);
    int rightVal = dfs(root.right, max);
    int extendLeft = 0, extendRight = 0;
    if (root.left != null && root.left.val == root.val)
      extendLeft += leftVal + 1;
    if (root.right != null && root.right.val == root.val)
      extendRight += rightVal + 1;
    max[0] = Math.max(max[0], extendLeft + extendRight);
    return Math.max(extendLeft, extendRight);
  }
}