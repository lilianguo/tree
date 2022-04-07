/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 *
 * <p>199. Binary Tree Right Side View Medium
 *
 * <p>Given the root of a binary tree, imagine yourself standing on the right side of it, return the
 * values of the nodes you can see ordered from top to bottom.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [1,2,3,null,5,null,4] Output: [1,3,4]
 *
 * <p>Example 2:
 *
 * <p>Input: root = [1,null,3] Output: [1,3]
 *
 * <p>Example 3:
 *
 * <p>Input: root = [] Output: []
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [0, 100]. -100 <= Node.val <= 100
 */
class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> view = new ArrayList<>();
    if (root == null) return view;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    while(!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        if (i == 0)
          view.add(curr.val);
        if (curr.right != null) q.add(curr.right);
        if (curr.left != null) q.add(curr.left);
      }
    }
    return view;
  }
}