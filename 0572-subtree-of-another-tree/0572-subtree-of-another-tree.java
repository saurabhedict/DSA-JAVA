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
    public boolean checkSubRoot(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;
        boolean left = checkSubRoot(root.left, subRoot.left);
        boolean right = checkSubRoot(root.right, subRoot.right);
        return (left && right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        boolean ansRoot = checkSubRoot(root, subRoot);
        boolean ansLeft = isSubtree(root.left, subRoot);
        boolean ansRight  = isSubtree(root.right, subRoot);
        return (ansRoot || ansLeft || ansRight);
    }
}