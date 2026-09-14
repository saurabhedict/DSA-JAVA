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
    public int[] solve(TreeNode root){
      if(root == null){
        int[] arr = {0, 0};
        return arr;
      }
      if(root.left == null && root.right == null){
        int[] arr = {root.val, 0};
        return arr;
      }
      int[] left = solve(root.left);
      int[] right = solve(root.right);

      int[] ans = new int[2];
      ans[0] = root.val + left[1] + right[1];
      ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); //[4,1,null,2,null,3]
      return ans;

    }
    public int rob(TreeNode root) {
      int[] arr =  solve(root);
      return Math.max(arr[0], arr[1]);
    }
}