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
 */
class Solution {
  public List<Integer> preRecursiveTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  private void helper(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    res.add(root.val);
    helper(root.left, res);
    helper(root.right, res);
  }

  public List<Integer> preStackTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while(!stack.isEmpty() || root != null) {
      while(curr != null) {
        res.add(curr.val);
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      curr = curr.right;
    }
    return res;
  }
}