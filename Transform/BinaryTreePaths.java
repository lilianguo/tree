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
 *
 * 257. Binary Tree Paths
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 */
class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    String path = "";
    helper(root, path, res);
    return res;
  }

  private void helper(TreeNode root, String path, List<String> res) {
    if (root != null) {
      path += Integer.toString(root.val);
      if (root.left == null && root.right == null) {
        res.add(path);
      } else {
        path += "->";
        helper(root.left, path, res);
        helper(root.right, path, res);
      }
    }
  }
}