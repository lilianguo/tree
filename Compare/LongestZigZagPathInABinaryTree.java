/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

/**
 * 1372. Longest ZigZag Path in a Binary Tree Medium
 *
 * <p>You are given the root of a binary tree.
 *
 * <p>A ZigZag path for a binary tree is defined as follow:
 *
 * <p>Choose any node in the binary tree and a direction (right or left). If the current direction
 * is right, move to the right child of the current node; otherwise, move to the left child. Change
 * the direction from right to left or from left to right. Repeat the second and third steps until
 * you can't move in the tree.
 *
 * <p>Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of
 * 0).
 *
 * <p>Return the longest ZigZag path contained in that tree.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1] Output: 3
 * Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
 *
 * <p>Example 2:
 *
 * <p>Input: root = [1,1,1,null,1,null,null,1,1,null,1] Output: 4 Explanation: Longest ZigZag path
 * in blue nodes (left -> right -> left -> right).
 *
 * <p>Example 3:
 *
 * <p>Input: root = [1] Output: 0
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [1, 5 * 104]. 1 <= Node.val <= 100
 *
 */
class Solution {
  // T:O(n), S: O(height)
  // dfs return new int[] {left, right, max}
  // left: maximum length in direction root.left
  // right: maximum length in direction root.right

  public int longestZigZag(TreeNode root) {
    return dfs(root)[2];
  }

  private int[] dfs(TreeNode root) {
    if (root == null) return new int[] {-1, -1, -1};
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);
    int res = Math.max(Math.max(left[1], right[0]) + 1, Math.max(left[2], right[2]));
    return new int[] {1 + left[1], 1 + right[0], res};
  }
}