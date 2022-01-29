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
 * 129. Sum Root to Leaf Numbers
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 *For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 * A leaf node is a node with no children.
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/solution/
 */
class Solution {
  // recursive way solving problem
  // Time complexity: O(N)\mathcal{O}(N)O(N) since one has to visit each node.
  // Space complexity: up to O(H)\mathcal{O}(H)O(H) to keep the recursion stack, where HHH is a tree height

  int sum = 0;
  public int sumNumbers(TreeNode root) {
    preorder(root, 0);
    return sum;
  }

  private void preorder(TreeNode root, int curr) {
    // System.out.println("loop start point curr val is " + curr);
    if (root != null) {
      curr = curr * 10 + root.val;
      // System.out.println("curr val is " + curr);
      if (root.left == null && root.right == null) {
        sum += curr;
      } else {
        preorder(root.left, curr);
        preorder(root.right, curr);
      }
    }
  }

  // iterative way
  public int sumNumbers(TreeNode root) {
    int rootToLeaf = 0, currNumber = 0;
    Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
    stack.push(new Pair(root, 0));

    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> p = stack.pop();
      root = p.getKey();
      currNumber = p.getValue();

      if (root != null) {
        currNumber = currNumber * 10 + root.val;
        // if it's a leaf, update root-to-leaf sum
        if (root.left == null && root.right == null) {
          rootToLeaf += currNumber;
        } else {
          stack.push(new Pair(root.right, currNumber));
          stack.push(new Pair(root.left, currNumber));
        }
      }
    }
    return rootToLeaf;
  }
}