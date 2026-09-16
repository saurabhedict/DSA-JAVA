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
//     public void fillArray(TreeNode root, ArrayList<Integer> list){
//         if(root == null) return;
//         fillArray(root.left, list);
//         list.add(root.val);
//         fillArray(root.right, list);
//     }
//     public boolean isValidBST(TreeNode root) {
//         ArrayList<Integer> list = new ArrayList<>();
//         fillArray(root, list);
//         int n = list.size();
//         for(int i = 1; i<n; i++){
//          if(list.get(i) <= list.get(i-1)) return false;
//         }
//         return true;
//     }
// }




// class Solution {
//     public long max(TreeNode root){
//       if(root == null) return Long.MIN_VALUE;
//       long current = root.val;
//       long left = max(root.left);
//       long right = max(root.right);
//       return Math.max(current, Math.max(left, right));
//     }
//     public long min(TreeNode root){
//       if(root == null) return Long.MAX_VALUE;
//       long current = root.val;
//       long left = min(root.left);
//       long right = min(root.right);
//       return Math.min(current, Math.min(left, right));
//     }
//     public boolean isValidBST(TreeNode root) {
//        if(root == null || (root.left == null && root.right == null)) return true;
//        if(root.val <= max(root.left)) return false;
//        if(root.val >= min(root.right)) return false;
//        return isValidBST(root.left) && isValidBST(root.right);
//     }
// }





// class Solution {
//     public void fillArray(TreeNode root, ArrayList<Integer> list){
//         if(root == null) return;
//         fillArray(root.left, list);
//         list.add(root.val);
//         fillArray(root.right, list);
//     }
//     public boolean isValidBST(TreeNode root) {
//         ArrayList<Integer> list = new ArrayList<>();
//         fillArray(root, list);
//         int n = list.size();
//         for(int i = 1; i<n; i++){
//          if(list.get(i) <= list.get(i-1)) return false;
//         }
//         return true;
//     }
// }




class Solution {
    boolean flag;
    public long max(TreeNode root){
      if(root == null) return Long.MIN_VALUE;
      long current = root.val;
      long left = max(root.left);
      if(current <= left) flag = false;
      long right = max(root.right);
      return Math.max(current, Math.max(left, right));
    }
    public long min(TreeNode root){
      if(root == null) return Long.MAX_VALUE;
      long current = root.val;
      long left = min(root.left);
      long right = min(root.right);
      if(current >= right) flag = false;
      return Math.min(current, Math.min(left, right));
    }
    public boolean isValidBST(TreeNode root) {
       flag = true;
       if(root == null || (root.left == null && root.right == null)) return true;
       max(root);
       min(root);
       return flag;
    }
}