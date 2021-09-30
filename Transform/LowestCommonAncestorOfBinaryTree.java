/*
236 Lowest Common Ancestor of a Binary Tree
this recursive call return a node if exist

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
*/
class LowestCommonAncestorOfBinaryTree {
    
    public TreeNode getAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }
        if (root == node1|| root == node2) {
            return root;
        }
        // when left is not null, it's either node1 or node2
        TreeNode left = getAncestor(root.left, node1, node2);
        // same: when right is not null, it's either node1 or node 2
        TreeNode right = getAncestor(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}