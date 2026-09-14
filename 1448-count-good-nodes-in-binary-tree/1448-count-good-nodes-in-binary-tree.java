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
    int good = 0;
    public void solve(TreeNode root, int prevPathMax){
       if(root == null) return;
       prevPathMax = Math.max(root.val, prevPathMax);
       if(root.val >= prevPathMax) good++;
       solve(root.left, prevPathMax);
       solve(root.right, prevPathMax);
    
    }
    public int goodNodes(TreeNode root) {
        solve(root, root.val);
        return good;
    }
}