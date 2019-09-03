/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        while(queue.get(queue.size() - 1) != null) {
            queue.remove(queue.size() - 1);
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                sb.append(",");
                sb.append("#");
            } else {
                sb.append(",");
                sb.append(node.val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] sArray = data.substring(1, data.length() - 1).split(",");
        boolean isLeft = true;
        TreeNode res = new TreeNode(Integer.parseInt(sArray[0]));
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(res);
        int index = 0;
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
        return res;       
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));