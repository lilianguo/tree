class BinaryTreeInorderTraversal {
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
                /* Find the inorder predecessor of current */
                pre = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                 /* Make current as right child of its inorder predecessor */
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    /* Revert the changes made in the 'if' part to restore the  
                    original tree i.e., fix the right child of predecessor*/
                    prev.right = null;
                    System.out.println("curr.val" + curr.val + " ");
                    curr = curr.right;                                   
                }
            }
        }
    }

    public List<Integer> traverseWithStack(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        while(!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            list.add(curr.val);
            if (curr.right != null) {
                curr = curr.right;
                while(curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            } else {
                curr = stack.pop();
                while(!stack.isEmpty() && stack.peek().right == curr) {
                    curr = stack.pop();
                }
            }
        }
        return list;
    }

    public List<Integer> traverseWithRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helper(root, list);
        return list;
    }
    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}