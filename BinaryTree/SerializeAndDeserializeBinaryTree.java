import java.util.Queue;

import ValidateBST.TreeNode;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#" + ",");
        } else {
            sb.append(root.val + ",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }
    
    private TreeNode deserialize(Queue<String> queue) {
        String curr = queue.poll();
        if (curr.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
