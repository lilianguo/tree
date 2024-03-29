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
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two
 * subtrees of every node never differs by more than one.
 */
class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) {
      return null;
    }
    TreeNode root = helper(nums,0, nums.length - 1);
    return root;
  }

  private TreeNode helper(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, start, mid -1);
    root.right = helper(nums, mid + 1, end);
    return root;
  }

}