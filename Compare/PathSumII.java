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
 * 113. Path Sum II
 *
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * -1000 <= Node.val <= 1000
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= targetSum <= 1000
 *
 */
class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    helper(root, targetSum, curr, res);
    return res;
  }

  private void helper(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> res) {
    if (root == null) {
      return;
    }
    curr.add(root.val);
    if (root.left == null && root.right == null && targetSum == root.val) {
      // copy the value out
      res.add(new ArrayList<>(curr));
    } else {
      helper(root.left, targetSum - root.val, curr, res);
      helper(root.right, targetSum - root.val, curr, res);
    }
    // this recursion finish, clear the curr
    curr.remove(curr.size() - 1);
  }
}