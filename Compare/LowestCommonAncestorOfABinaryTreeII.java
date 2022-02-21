/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 1644. Lowest Common Ancestor of a Binary Tree II
 *
 * Given the root of a binary tree,
 * return the lowest common ancestor (LCA) of two given nodes, p and q.
 * If either node p or q does not exist in the tree, return null.
 * All values of the nodes in the tree are unique.
 *
 *
 * According to the definition of LCA on Wikipedia:
 * "The lowest common ancestor of two nodes p and q in a binary tree T
 * is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)".
 * A descendant of a node x is a node y that is on the path from node x to some leaf node.
 *
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 */
class Solution {
  // Compared to I, p and q might not exist in tree root
  // time limit exceed
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    boolean pFound = nodeFound(root, p);
    boolean qFound = nodeFound(root, q);
    if (pFound && qFound)
      return helper(root, p, q);
    return null;
  }

  private boolean nodeFound(TreeNode root, TreeNode p) {
    if (root == null)
      return false;
    if (root == p)
      return true;
    return nodeFound(root.left, p) || nodeFound(root.right, p);
  }


  private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == q || root == p) {
      return root;
    }
    TreeNode left = helper(root.left, p, q);
    TreeNode right = helper(root.right, p, q);
    if (left != null && right != null)
      return root;
    if (left == null)
      return right;
    return left;
  }

  /// one pass solution: dfs tree, return pair (node, # of nodes see)

}