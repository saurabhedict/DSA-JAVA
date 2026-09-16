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
    public void fillArray(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        fillArray(root.left, list);
        list.add(root.val);
        fillArray(root.right, list);
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        fillArray(root, list);
        int n = list.size();
        boolean flag = true;
        for(int i = 1; i<n; i++){
         if(list.get(i) <= list.get(i-1)) return false;
        }
        return flag;
    }
}