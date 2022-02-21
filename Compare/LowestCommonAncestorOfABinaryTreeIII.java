/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

/**
 * 1650. Lowest Common Ancestor of a Binary Tree III Medium
 *
 * <p>Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 *
 * <p>Each node will have a reference to its parent node. The definition for Node is below:
 *
 * <p>class Node { public int val; public Node left; public Node right; public Node parent; }
 *
 * <p>According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p
 * and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node
 * to be a descendant of itself)."
 *
 * <p>Example 1:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 Output: 3 Explanation: The LCA of
 * nodes 5 and 1 is 3.
 *
 * <p>Example 2:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 Output: 5 Explanation: The LCA of
 * nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
 *
 * <p>Example 3:
 *
 * <p>Input: root = [1,2], p = 1, q = 2 Output: 1
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [2, 105]. -109 <= Node.val <= 109 All Node.val
 * are unique. p != q p and q exist in the tree.
 */
class Solution {
  public Node lowestCommonAncestor(Node p, Node q) {
    Node root = findRoot(p);
    Node res = helper(root, p, q);
    return res;
  }

  private Node helper(Node root, Node p, Node q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    Node left = helper(root.left, p, q);
    Node right = helper(root.right, p, q);
    if (left != null && right != null)
      return root;
    if (left == null)
      return right;
    return left;
  }

  private Node findRoot(Node p) {
    Node root = p;
    while(root.parent != null) {
      root = root.parent;
    }
    return root;
  }
}