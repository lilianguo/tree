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
  // T:O(n) S:O(N)
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    if (root.left == null && root.right == null) return true;
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> nums = new ArrayList<>();
    int prev = Integer.MIN_VALUE;
    while(root != null || !stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      nums.add(root.val);
      // System.out.println(nums.size());
      if (nums.size() > 1 && nums.get(nums.size() - 1) <= nums.get(nums.size() - 2)) {
        // System.out.println("minus result");
        // System.out.println(nums.get(nums.size() - 1) - nums.get(nums.size() - 2) );
        return false;
      }
      prev = root.val;
      root = root.right;
    }
    return true;
  }
}