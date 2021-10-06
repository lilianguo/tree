/*
96. Unique Binary Search Trees
Given an integer n, return the number of structurally unique BST's
(binary search trees) which has exactly n nodes of unique values from 1 to n.
 */
class Solution {
  // recursive
  // num of Trees is calculated by try every num as root,
  // and the num of unique left chidren * # of unique right children
  public int numTrees(int n) {
    if (n == 0) {
      return 1;
    }
    else if (n < 3) {
      return n;
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int curr = numTrees(i) * numTrees(n - i - 1);
      sum += curr;
    }
    return sum;
  }

  // top to down, cut half time
  public int numTreesII(int n) {
    if (n == 0) {
      return 1;
    }
    else if (n < 3) {
      return n;
    }
    int sum = 0;
    for (int i = 0; i < n/2; i++) {
      int curr = 2 *(numTrees(i) * numTrees(n - i - 1));
      sum += curr;
    }
    if (n % 2 != 0) {
      sum += numTrees(n/2) * numTrees(n/2);
    }
    return sum;
  }

  // above 2 is actually using DP mindset, I'll fomalize it into DP format code
  public int numTreesDP(int n) {
    int[] sum = new int[n + 1];
    sum[0] = 1;
    sum[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i;j++) {
        sum[i] += sum[j - 1] * sum[i - j];
      }
    }
    return sum[n];
  }

}