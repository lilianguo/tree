/**
 * 437. Path Sum III Medium
 *
 * <p>Given the root of a binary tree and an integer targetSum, return the number of paths where the
 * sum of the values along the path equals targetSum.
 *
 * <p>The path does not need to start or end at the root or a leaf, but it must go downwards (i.e.,
 * traveling only from parent nodes to child nodes).
 *
 * <p>Example 1:
 *
 * <p>Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8 Output: 3 Explanation: The
 * paths that sum to 8 are shown.
 *
 * <p>Example 2:
 *
 * <p>Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22 Output: 3
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [0, 1000]. -109 <= Node.val <= 109 -1000 <=
 * targetSum <= 1000
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

  public int pathSum(TreeNode root, int targetSum) {
    HashMap<Integer, Integer> sumMap = new HashMap<>();
    int[] count = new int[1];
    int[] currSum = new int[1];
    dfs(root, targetSum, currSum, count, sumMap);
    return count[0];
  }



  private void dfs(TreeNode root, int targetSum, int[] currSum, int[] count, HashMap<Integer, Integer> sumMap) {
    if (root == null) return;

    // System.out.println("root is " + root.val + "\n");
    currSum[0] += root.val;
    // System.out.println("currSum is " + currSum[0] + "\n");
    // with this root val, preSum from tree root to this node is exactly targetSum we're looking for
    if (currSum[0] == targetSum){
      // System.out.println("count is " + count[0] + "\n");
      count[0]++;
    }


    // add count of the times where the prefix sum before adding this node has reached (targetSum - currSum)
    count[0] += sumMap.getOrDefault(currSum[0] - targetSum, 0);
    // System.out.println("count is " + count[0] + "\n");
    // add root val related map
    sumMap.put(currSum[0], sumMap.getOrDefault(currSum[0], 0) + 1);

    // after adding this node val, check the chidren
    dfs(root.left, targetSum, currSum, count, sumMap);
    dfs(root.right, targetSum, currSum, count, sumMap);
    // delete this root val related map
    sumMap.put(currSum[0], sumMap.get(currSum[0]) - 1);
    currSum[0] -= root.val;
  }
}