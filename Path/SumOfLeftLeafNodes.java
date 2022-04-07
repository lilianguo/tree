/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 *
 * <p>404. Sum of Left Leaves Easy
 *
 * <p>Given the root of a binary tree, return the sum of all left leaves.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [3,9,20,null,null,15,7] Output: 24 Explanation: There are two left leaves in the
 * binary tree, with values 9 and 15 respectively.
 *
 * <p>Example 2:
 *
 * <p>Input: root = [1] Output: 0
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [1, 1000]. -1000 <= Node.val <= 1000
 *
 *
 */
class Solution {
  // bfs
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    int sum = 0;
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));
    while(!queue.isEmpty()) {
      Pair curr = queue.poll();
      if (curr.direction == 1 && curr.node.left == null && curr.node.right == null) sum += curr.node.val;
      if (curr.node.left != null) queue.add(new Pair(curr.node.left, 1));
      if (curr.node.right != null) queue.add(new Pair(curr.node.right, 0));
    }
    return sum;
  }
  class Pair{
    TreeNode node;
    Integer direction;
    public Pair(TreeNode node, int direction) {
      this.node = node;
      this.direction = direction;
    }
  }

  // recursive
  public int sumOfLeftLeavesII(TreeNode root) {
    if (root == null) return 0;
    return sumLeftLeaf(root, false);
  }

  public int sumLeftLeaf(TreeNode root, boolean isLeft) {
    if (root == null) return 0;
    if (isLeft && root.left == null && root.right == null)
      return root.val;
    return sumLeftLeaf(root.left, true) + sumLeftLeaf(root.right, false);
  }
}