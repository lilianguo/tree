/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 */

 // 250. Count Univalue Subtrees

 // time: O(n)
 // space: O(H)
class CountUnivalSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode root, int[] count) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);
        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}