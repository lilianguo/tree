/**
* 662. Maximum Width of Binary Tree
  Medium

  Given the root of a binary tree, return the maximum width of the given tree.

  The maximum width of a tree is the maximum width among all levels.

  The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

  It is guaranteed that the answer will in the range of 32-bit signed integer.



  Example 1:

  Input: root = [1,3,2,5,3,null,9]
  Output: 4
  Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

  Example 2:

  Input: root = [1,3,null,5,3]
  Output: 2
  Explanation: The maximum width existing in the third level with the length 2 (5,3).

  Example 3:

  Input: root = [1,3,2,5]
  Output: 2
  Explanation: The maximum width existing in the second level with the length 2 (3,2).



  Constraints:


    The number of nodes in the tree is in the range [1, 3000].
    -100 <= Node.val <= 100

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
/**
public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        // queue of elements [(node, col_index)]
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Integer maxWidth = 0;

        queue.addLast(new Pair<>(root, 0));
        while (queue.size() > 0) {
            Pair<TreeNode, Integer> head = queue.getFirst();

            // iterate through the current level
            Integer currLevelSize = queue.size();
            Pair<TreeNode, Integer> elem = null;
            for (int i = 0; i < currLevelSize; ++i) {
                elem = queue.removeFirst();
                TreeNode node = elem.getKey();
                // index every not null node
                if (node.left != null)
                    queue.addLast(new Pair<>(node.left, 2 * elem.getValue()));
                if (node.right != null)
                    queue.addLast(new Pair<>(node.right, 2 * elem.getValue() + 1));
            }

            // calculate the length of the current level,
            //   by comparing the first and last col_index.
            maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
        }

        return maxWidth;
    }*/
    public int widthOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;

            // queue of elements [(node, col_index)]
            LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            Integer maxWidth = 0;

            queue.addLast(new Pair<>(root, 0));
            while (queue.size() > 0) {
                Pair<TreeNode, Integer> head = queue.getFirst();

                // iterate through the current level
                Integer currLevelSize = queue.size();
                Pair<TreeNode, Integer> elem = null;
                for (int i = 0; i < currLevelSize; ++i) {
                    elem = queue.removeFirst();
                    TreeNode node = elem.getKey();
                    // index every not null node
                    if (node.left != null)
                        queue.addLast(new Pair<>(node.left, 2 * elem.getValue()));
                    if (node.right != null)
                        queue.addLast(new Pair<>(node.right, 2 * elem.getValue() + 1));
                }

                // calculate the length of the current level,
                //   by comparing the first and last col_index.
                maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
            }

            return maxWidth;
        }
}