/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * 112. Path Sum
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) {
        return false;
      }
      return helper(root, targetSum);
    }

    private boolean helper(TreeNode root, int targetSum) {
      if (root.left == null && root.right == null) {
        if (targetSum == root.val ) {
          return true;
        } else {
          return false;
        }
      }
      if (root.left != null || root.right != null) {
        if (root.left == null) {
          return helper(root.right, targetSum - root.val);
        }
        if (root.right == null) {
          return helper(root.left, targetSum - root.val);
        }
      }
      return helper(root.left, targetSum - root.val) || helper(root.right, targetSum - root.val);
    }
  }
}