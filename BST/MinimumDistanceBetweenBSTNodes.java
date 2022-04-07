/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 *
 * <p>783. Minimum Distance Between BST Nodes Easy
 *
 * <p>Given the root of a Binary Search Tree (BST), return the minimum difference between the values
 * of any two different nodes in the tree.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [4,2,6,1,3] Output: 1
 *
 * <p>Example 2:
 *
 * <p>Input: root = [1,0,48,null,null,12,49] Output: 1
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [2, 100]. 0 <= Node.val <= 105
 *
 * <p>Note: This question is the same as 530:
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 */
class Solution {
  // T: O(N) S: O(N)
  public int minDiffInBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while(curr != null || !stack.isEmpty()) {
      while(curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      list.add(curr.val);
      curr = curr.right;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < list.size(); i++) {
      min = Math.min(min, list.get(i) - list.get(i - 1));
    }
    return min;
  }

  // T: O(N) S: O(N)
  public int minDiffInBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    int min = Integer.MAX_VALUE;
    while(curr != null || !stack.isEmpty()) {
      while(curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      list.add(curr.val);
      if (list.size() > 1) min = Math.min(min, list.get(list.size() - 1) - list.get(list.size() - 2));
      curr = curr.right;
    }
    return min;
  }
}