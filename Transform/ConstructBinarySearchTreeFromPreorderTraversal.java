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
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
 * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
 * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
 * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 * All the values of preorder are unique.
 * 1008. Construct Binary Search Tree from Preorder Traversal
 */
class Solution {
  // TIME O(N^2)
  //  SPACE O(N)
  public TreeNode bstFromPreorder(int[] preorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }
    TreeNode root = helper(preorder, 0, preorder.length - 1);
    return root;
  }

  private TreeNode helper(int[] preorder, int left, int right) {
    if (left > right) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[left]);
    int i = left + 1;
    while(i <= right && preorder[i] < preorder[left]) {
      i++;
    }
    root.left = helper(preorder, left + 1, i - 1);
    root.right = helper(preorder, i, right);
    return root;
  }
}