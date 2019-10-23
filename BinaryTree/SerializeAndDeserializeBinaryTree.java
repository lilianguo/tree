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
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode curr  = queue.get(i);
            if (curr == null) {
                continue;
            }
            queue.add(curr.left);
            queue.add(curr.right);
        }
        while(queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode curr = queue.get(i);
            if (curr == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(curr.val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "" || data.length() == 0) {
            return null;
        }

        String[] sArray = data.substring(1, data.length() - 1).split(",");
        boolean isLeft = true;
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(sArray[0]));
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        for (int i = 1; i < sArray.length; i++) {
            if (!sArray[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(sArray[i]));
                if (isLeft) {
                    list.get(index).left = node;
                } else {
                    list.get(index).right = node;
                }
                list.add(node);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}
