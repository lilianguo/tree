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
 * 113. Path Sum II
 *
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * -1000 <= Node.val <= 1000
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= targetSum <= 1000
 *
 */
class Solution {

  /**
   *

   Time Complexity: OO(N^2) where N are the number of nodes in a tree.
   In the worst case, we could have a complete binary tree and if that is the case,
   then there would be N/2 leafs. For every leaf, we perform a potential O(N) operation of copying over the pathNodes nodes to a new list to be added to the final pathsList. Hence, the complexity in the worst case could be O(N2)O(N^2)O(N2).

   Space Complexity: O(N).
   The space complexity, like many other problems is debatable here.
   I personally choose not to consider the space occupied by the output in the space complexity.
   So, all the new lists that we create for the paths are actually a part of the output and hence,
   don't count towards the final space complexity. The only additional space that we use is the pathNodes list to keep track of nodes along a branch.
   * @param root
   * @param targetSum
   * @return
   */
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    helper(root, targetSum, curr, res);
    return res;
  }

  private void helper(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> res) {
    if (root == null) {
      return;
    }
    curr.add(root.val);
    if (root.left == null && root.right == null && targetSum == root.val) {
      // copy the value out
      res.add(new ArrayList<>(curr));
    } else {
      helper(root.left, targetSum - root.val, curr, res);
      helper(root.right, targetSum - root.val, curr, res);
    }
    // this recursion finish, clear the curr
    curr.remove(curr.size() - 1);
  }
}