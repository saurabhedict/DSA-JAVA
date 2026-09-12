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
    public void preOrder(TreeNode root, int sum, ArrayList<Integer> ans){
        sum += root.val;
        if(root.left == null && root.right == null) ans.add(sum);
        if(root.left != null) preOrder(root.left, sum*10, ans);
        if(root.right != null) preOrder(root.right, sum*10, ans);
    }
    public int sumNumbers(TreeNode root) {
      if(root.left == null && root.right == null) return root.val;
      ArrayList<Integer> ans = new ArrayList<>();
      preOrder(root, 0, ans);
      int sum = 0;
      for(int i = 0; i<ans.size(); i++){
         sum += ans.get(i);
      }
      return sum;
    }
}