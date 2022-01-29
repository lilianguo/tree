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
 * 1305. All Elements in Two Binary Search Trees
 * Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
 *
 * The number of nodes in each tree is in the range [0, 5000].
 * -105 <= Node.val <= 105

 */
class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> inorder1 = new ArrayList<>();
    List<Integer> inorder2 = new ArrayList<>();
    getList(root1, inorder1);
    getList(root2, inorder2);
    List<Integer> merged = new ArrayList<>();
    int n1 = inorder1.size(), n2 = inorder2.size();
    int p1 = 0, p2 = 0;
    while(p1 < n1 || p2 < n2) {
      if (p1 == n1){
        merged.add(inorder2.get(p2));
        p2++;
      } else if(p2 == n2) {
        merged.add(inorder1.get(p1));
        p1++;
      } else {
        if (inorder1.get(p1) < inorder2.get(p2)) {
          merged.add(inorder1.get(p1));
          p1++;
        } else {
          merged.add(inorder2.get(p2));
          p2++;
        }
      }
    }
    return merged;
  }

  private void getList(TreeNode root, List<Integer> nums) {
    if (root == null)
      return;
    getList(root.left, nums);
    nums.add(root.val);
    getList(root.right, nums);
  }

}