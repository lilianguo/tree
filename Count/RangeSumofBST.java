/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 *
 * <p>938. Range Sum of BST Easy
 *
 * <p>Given the root node of a binary search tree and two integers low and high, return the sum of
 * values of all nodes with a value in the inclusive range [low, high].
 *
 */
class Solution {
  public int rangeSumBST(TreeNode root, int low, int high) {
    List<Integer> nums = new ArrayList<>();
    inorder(root, nums);
    int sum = 0;
    for (int num : nums) {
      if (low <= num && num <= high) {
        sum += num;
      }
    }
    return sum;
  }

  private void inorder(TreeNode root, List<Integer> nums ) {
    if (root == null) return;
    inorder(root.left, nums);
    nums.add(root.val);
    inorder(root.right, nums);
    return;
  }


  public int rangeSumBSTII(TreeNode root, int low, int high) {
    int[] res = new int[1];
    helper(root, low, high, res);
    return res[0];
  }

  private void helper(TreeNode root, int low, int high, int[] res) {
    if (root == null)
      return;

    helper(root.left, low, high, res);
    res[0] += root.val >= low && root.val <= high ? root.val : 0;
    helper(root.right, low, high, res);
  }
}