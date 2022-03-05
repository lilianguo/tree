/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 *
 * <p>863. All Nodes Distance K in Binary Tree Medium
 *
 * <p>Given the root of a binary tree, the value of a target node target, and an integer k, return
 * an array of the values of all nodes that have a distance k from the target node.
 *
 * <p>You can return the answer in any order.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2 Output: [7,4,1] Explanation:
 * The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 *
 * <p>Example 2:
 *
 * <p>Input: root = [1], target = 1, k = 3 Output: []
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [1, 500]. 0 <= Node.val <= 500 All the values
 * Node.val are unique. target is the value of one of the nodes in the tree. 0 <= k <= 1000
 */
class Solution {
  // 标记target的所有parent
  // 然后 从target开始 bfs 一圈一圈， 到root之前需要getParent, 到root之后全是children

  /**
   *

   Time Complexity: O(N), where NNN is the number of nodes in the given tree.

   Space Complexity: O(N).
   * @param root
   * @param target
   * @param k
   * @return
   */
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    Set<TreeNode> vis = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    q.add(root);
    while(!q.isEmpty()) {
      TreeNode curr = q.poll();
      // System.out.println("curr val is " + curr.val);
      if (curr == target) break;
      if (curr.left != null) {
        map.put(curr.left, curr);
        q.add(curr.left);
      }
      if (curr.right != null) {
        map.put(curr.right, curr);
        q.add(curr.right);
      }
    }
    q.clear();
    q.add(target);
    vis.add(target);
    while(k > 0) {
      if (q.isEmpty()) return res;

      for (int size = q.size(); size > 0; size--) {
        TreeNode curr = q.poll();
        if (curr.left != null && !vis.contains(curr.left)){
          q.add(curr.left);
          vis.add(curr.left);
        }
        if (curr.right != null && !vis.contains(curr.right)) {
          q.add(curr.right);
          vis.add(curr.right);
        }
        if (map.containsKey(curr) && !vis.contains(map.get(curr))) {
          q.add(map.get(curr));
          vis.add(map.get(curr));
        }
      }
      k--;
    }
    while(!q.isEmpty()) {
      res.add(q.poll().val);
    }
    return res;
  }
}