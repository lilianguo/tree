/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } } 1676. Lowest Common Ancestor of a Binary Tree IV Medium
 *
 * <p>Given the root of a binary tree and an array of TreeNode objects nodes, return the lowest
 * common ancestor (LCA) of all the nodes in nodes. All the nodes will exist in the tree, and all
 * values of the tree's nodes are unique.
 *
 * <p>Extending the definition of LCA on Wikipedia: "The lowest common ancestor of n nodes p1, p2,
 * ..., pn in a binary tree T is the lowest node that has every pi as a descendant (where we allow a
 * node to be a descendant of itself) for every valid i". A descendant of a node x is a node y that
 * is on the path from node x to some leaf node.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7] Output: 2 Explanation: The lowest
 * common ancestor of nodes 4 and 7 is node 2.
 *
 * <p>Example 2:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [1] Output: 1 Explanation: The lowest
 * common ancestor of a single node is the node itself.
 *
 * <p>Example 3:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [7,6,2,4] Output: 5 Explanation: The
 * lowest common ancestor of the nodes 7, 6, 2, and 4 is node 5.
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [1, 104]. -109 <= Node.val <= 109 All Node.val
 * are unique. All nodes[i] will exist in the tree. All nodes[i] are distinct.
 */
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    if (nodes == null || nodes.length == 0)
      return null;

    if (nodes.length == 1)
      return nodes[0];

    Set<TreeNode> set = new HashSet<>();
    for (TreeNode node : nodes) {
      set.add(node);
    }
    for (TreeNode node : nodes) {
      removeChildren(node, set);
      // System.out.println("set size now is " + set.size() + "\n");
    }
    List<TreeNode> remain = new ArrayList<>();
    for (TreeNode node : set) {
      remain.add(node);
    }
    if (remain.size() == 1)
      return remain.get(0);
    return helper(root, remain.get(0), remain.get(1));
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

  private void removeChildren(TreeNode node, Set<TreeNode> set) {
    if (node == null)
      return;
    if (set.contains(node.left))
      set.remove(node.left);
    if (set.contains(node.right))
      set.remove(node.right);
    removeChildren(node.left, set);
    removeChildren(node.right, set);
  }



  // O(n)
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    Set<Integer> set = new HashSet<>();
    for (TreeNode node : nodes) {
      set.add(node.val);
    }
    TreeNode res = helper(root, set);
    return res;
  }

  private TreeNode helper(TreeNode root, Set<Integer> set) {
    if (root == null) {
      return null;
    }
    if (set.contains(root.val)) return root;

    TreeNode left = helper(root.left, set);
    TreeNode right = helper(root.right, set);
    if (left == right) return null;
    if (left != null && right != null) return root;
    else if (left == null) return right;
    return left;
  }

}