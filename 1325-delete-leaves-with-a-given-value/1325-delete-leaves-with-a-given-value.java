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
 
// class Solution {
//     public boolean solve(TreeNode root, int target){
//         if(root == null) return false;
//         if((root.left == null && root.right == null) && root.val == target) return true;
        
//         boolean x = solve(root.left, target);
//         if(x) {
//             root.left = null;
//             if(root.right == null && root.val == target) return true;
//         }

//         boolean y = solve(root.right, target);
//          if(y) {
//             root.right = null;
//             if(root.left == null && root.val == target) return true;
//         }

//         return false;
//     }
//     public TreeNode removeLeafNodes(TreeNode root, int target) {
//         if((root.left == null && root.right == null) && root.val == target) return null;
//         boolean ans = solve(root, target);
//         if(ans) return null;
//         return root;
//     }
// }




class Solution {
    public TreeNode solve(TreeNode root, int target){
        if(root == null) return null;
        root.left = solve(root.left, target);
        root.right = solve(root.right, target);
        if((root.left == null && root.right == null) && root.val == target) return null;
        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if((root.left == null && root.right == null) && root.val == target) return null;
        TreeNode ans = solve(root, target);
        return ans;
    }
}