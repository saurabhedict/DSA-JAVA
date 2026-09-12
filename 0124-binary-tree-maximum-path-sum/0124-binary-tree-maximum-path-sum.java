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
    int maxSum;
    public int solve(TreeNode root){
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);
        
        int combintionOfThree = left + right + root.val;
        int BestIsAnyOne = Math.max(left, right) + root.val; //from of left or right
        int rootIsBest  = root.val;
        maxSum = Math.max(maxSum, Math.max(combintionOfThree, Math.max(BestIsAnyOne, rootIsBest)));


        return Math.max(BestIsAnyOne, rootIsBest);
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}