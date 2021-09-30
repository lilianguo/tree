class DeleteNodeInABST {
    // 450. Delete Node in a BST
    // recursive delete node
    // to find the node to delete: O(hight of root to the node to delete)
    // to find a min in right substree, O(hight of node to deleted to leaf node)
    // delete node takes O(1)
    // together O(h1 + h1) = O(Height of tree) = (logn) for BST

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minRight = findMinRight(root.right);
            root.right = deleteNode(root.right, minRight.val);
            root.val = minRight.val;
        }
        return root;
    }
    private TreeNode findMinRight(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}