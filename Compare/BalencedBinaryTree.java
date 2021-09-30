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
 * Given a binary tree, determine if it is height-balanced.
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
class Solution {
  // This uses global variable, how can I not use global variable
  private boolean res = true;

  public boolean isBalanced(TreeNode root) {
    maxDepth(root);
    return res;
  }

  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxL = maxDepth(root.left);
    int maxR = maxDepth(root.right);
    if (Math.abs(maxL - maxR) > 1) {
      res = false;
      return 0;
    }
    return Math.max(maxL, maxR) + 1;
  }
//////////////////////////////////////////////////////////////////////
  // This one use array to pass long the value of true/false, if use boolean to pass, it would lose the value
  // so booean[] is required
  public boolean isBalancedII(TreeNode root) {
    boolean[] res = new boolean[1];
    res[0] = true;
    helper(root, res);
    return res[0];
  }

  private int helper(TreeNode root, boolean[] res) {
    if (root == null) {
      return 0;
    }
    int maxl = helper(root.left, res);
    int maxr = helper(root.right, res);
    if (Math.abs(maxl - maxr) > 1) {
      res[0] = false;
      return 0;
    }
    return 1 + Math.max(maxl, maxr);
  }
}