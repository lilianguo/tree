/*
235. Lowest Common Ancestor of a Binary Search Tree



Time Complexity: O(N), where N is the number of nodes in the BST. 
In the worst case we might be visiting all the nodes of the BST.

Space Complexity: O(N). 
This is because the maximum amount of space utilized by the recursion stack would be NNN since the height of a skewed BST could be N. 
*/
class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*if (root.val == p.val || root.val == q.val) {
            return root;
        }*/
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}