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
    public int level(TreeNode root){
        if(root == null) return 0;
        int left = level(root.left);
        int right = level(root.right);
        return 1 + Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        int current = level(root.left) + level(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(current, Math.max(left, right));
    }
}