/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/
class ConstructBinaryTreeFromPreAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper (int[] preorder, int preStart, int preEnd,
                                int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdx = findPosition(preorder[preStart], inorder, inStart, inEnd);
        int lenLeft = rootIdx - inStart;
        root.left = helper(preorder, preStart + 1, preStart + lenLeft, inorder, inStart, rootIdx - 1);
        root.right = helper(preorder, preStart + lenLeft + 1, preEnd, inorder, rootIdx + 1, inEnd);
        return root;
    }

    private Integer findPosition(int num, int[] inorder, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++){
            if (num == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}