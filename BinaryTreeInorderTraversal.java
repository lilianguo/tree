class BinaryTreeInOrderTraversal {
    // O(n) recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }   
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    // traversal
    public List<Integer> inorderTraversalII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            res.add(node.val);
            if (node.right == null) {
                node = stack.pop();
                while(!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

        }
        return res;
    }

    // morris no stack no recursion
    // https://www.cnblogs.com/anniekim/archive/2013/06/15/morristraversal.html
    public void morris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr, prev;
        curr = root;
        while(curr != null) {
            if (curr.left == null) {
                System.out.println("curr.val" + curr.val + " ");
                curr = curr.right;
            } else {
                pre = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    System.out.println("curr.val" + curr.val + " ");
                    curr = curr.right;                                   
                }
            }
        }
    }
}