/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class DeleteNodeInABST {
    // https://leetcode.com/problems/delete-node-in-a-bst/
    // Time complexity should be O(height of tree).
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // find the node to be deleted
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            // node found;
            // case 1: 无左子树
            if (root.left == null) {
                return root.right;
            }
            // case 2: 无右子树
            if (root.right == null) {
                return root.left;
            }
            // case 3: 左右子树都有
            TreeNode minRight = findMin(root.right);
            root.val = minRight.val;
            root.right = deleteNode(root.right, minRight.val);
        }
        
        return root;
    }
    
    private TreeNode findMin(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}