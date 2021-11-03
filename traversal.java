class TreeTraversal {
  public void preorder(TreeNode root, List<Integer> nums) {
    if (root == null)
      return;
    nums.add(root.val);
    preorder(root.left, nums);
    preorder(root.right, nums);
  }

  public void inorder(TreeNode root, List<Integer> nums) {
    if (root == null)
      return;
    inorder(root.left, nums);
    nums.add(root.val);
    inorder(root.right, nums);
  }

  public void postorder(TreeNode root, List<Integer> nums) {
    if (root == null)
      return;
    postorder(root.left, nums);
    postorder(root.right, nums);
    nums.add(root.val);
  }
}
