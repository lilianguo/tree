class ValidateBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    //采用分治法，时间复杂度 O(n)
    // DFS
    // [5,1,4,null,null,3,6]
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, null, null);
    }
    
    // recursive call 时间复杂度 O(n)
    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        // base case
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        // check left subtree 
        if (!helper(root.left, lower, val)) {
            return false;
        }
        // check right subtree
        if (!helper(root.right, val, upper)) {
            return false;
        }
        return true;
    }
    
    // In order traversal method 1
    public boolean isValidBSTII(TreeNode node) {
        if (node == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        TreeNode prev = null;
        while(!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (prev != null && prev.val >= curr.val) {
                return false;
            }
            prev = curr;
            if (curr.right == null) {
                curr = stack.pop();
                while(!stack.isEmpty() && stack.peek().right == curr) {
                    curr = stack.pop();
                }
            } else {
                curr = curr.right;
                while(curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        return true;
    }

    // using in order traversal method II
    public boolean isBSTII(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double prev = - Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}