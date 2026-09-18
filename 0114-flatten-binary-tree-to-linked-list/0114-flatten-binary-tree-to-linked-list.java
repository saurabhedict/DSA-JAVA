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
//     public void fillList(TreeNode root, ArrayList<TreeNode> list){
//         if(root == null) return;
//         list.add(root);
//         fillList(root.left, list);
//         fillList(root.right, list);
//     }
//     public void flatten(TreeNode root) {
//         ArrayList<TreeNode> list = new ArrayList<>();
//         fillList(root, list);
//         int n = list.size();
//         for(int i = 0; i<n-1; i++){
//             TreeNode temp = list.get(i);
//             temp.right = list.get(i+1);
//             temp.left = null;
//         }
//         return;
//     }
// }


class Solution {
    public TreeNode solve(TreeNode root){
     if(root == null) return null;
     if(root.left == null && root.right == null) return root;
     if(root.left == null) {
        root.right = solve(root.right);
        return root;
     }
     if(root.right == null){
        root.right = solve(root.left);
        root.left = null;
        return root;
     }

     TreeNode left = root.left;
     TreeNode right = root.right;
     root.left = null;
     root.right = null;
     left = solve(left);
     right = solve(right);
     TreeNode temp = left;
     while(temp.right != null){
        temp = temp.right;
     }
     root.right = left;
     temp.right = right;
     return root;
       
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        solve(root);
    }
}