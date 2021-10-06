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
 * 95. Unique Binary Search Trees II
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 */
class Solution {
  // definitely a hard followup in interview
  // recursively create all subtrees with all roots
  public List<TreeNode> generateTrees(int n) {
    return helper(1, n);
  }

  private List<TreeNode> helper(int start, int end) {
    List<TreeNode> trees = new ArrayList<>();
    if (start > end) {
      trees.add(null);
      return trees;
    }
    if (start == end) {
      TreeNode root = new TreeNode(start);
      trees.add(root);
      return trees;
    }

    for (int rootVal = start; rootVal <= end; rootVal++) {
      List<TreeNode> left = helper(start, rootVal - 1);
      List<TreeNode> right = helper(rootVal + 1, end);
      for (TreeNode subl : left) {
        for (TreeNode subr : right) {
          TreeNode root = new TreeNode(rootVal);
          root.left = subl;
          root.right = subr;
          trees.add(root);
        }
      }
    }
    return trees;
  }
}