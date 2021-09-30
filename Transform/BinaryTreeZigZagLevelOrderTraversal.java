// 103. Binary Tree Zigzag Level Order Traversal
class BinayTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                line.add(curr.val);
            }
            if (!leftToRight) {
                Collections.reverse(line);
            }
            leftToRight = !leftToRight;
            res.add(line);
        }
        return res;
    }
}