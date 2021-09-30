
// 173. Binary Search Tree Iterator
class BinarySearchTreeInterator {
    private Queue<Integer> queue;
    public BSTIterator(TreeNode root) {
        queue = getQueue(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private Queue<Integer> getQueue(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        if (root == null) {
            return queue;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            queue.add(node.val);
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
        return queue;
    }
}