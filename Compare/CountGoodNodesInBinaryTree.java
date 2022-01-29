/**
 * 1448. Count Good Nodes in Binary Tree Medium
 *
 * <p>Given a binary tree root, a node X in the tree is named good if in the path from root to X
 * there are no nodes with a value greater than X.
 *
 * <p>Return the number of good nodes in the binary tree.
 *
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

  private int num = 0;

  public int goodNodes(TreeNode root) {
    if (root == null)
      return num;
    dfs(root, Integer.MIN_VALUE);
    return num;
  }

  private void dfs(TreeNode root, int maxValue) {
    if (maxValue <= root.val) {
      num++;
    }
    if (root.left != null) {
      dfs(root.left, Math.max(root.val, maxValue));
    }
    if (root.right != null) {
      dfs(root.right, Math.max(root.val, maxValue));
    }
  }
}


// No 全局变量
class Pair {
  public TreeNode node;
  public int currMax;

  public Pair(TreeNode node, int currMax) {
    this.node = node;
    this.currMax = currMax;
  }
}

class Solution {
  public int goodNodes(TreeNode root) {
    int count = 0;
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root, Integer.MIN_VALUE));
    while (!stack.isEmpty()) {
      Pair curr = stack.pop();
      if (curr.currMax <= curr.node.val) {
        count++;
      }
      if (curr.node.left != null) {
        stack.push(new Pair(curr.node.left, Math.max(curr.currMax, curr.node.val)));
      }
      if (curr.node.right != null) {
        stack.push(new Pair(curr.node.right, Math.max(curr.currMax, curr.node.val)));
      }
    }
    return count;
  }
}