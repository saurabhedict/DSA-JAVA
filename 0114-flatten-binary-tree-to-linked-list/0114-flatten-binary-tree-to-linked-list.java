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
    public void fillList(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;
        list.add(root);
        fillList(root.left, list);
        fillList(root.right, list);
    }
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        fillList(root, list);
        int n = list.size();
        for(int i = 0; i<n-1; i++){
            TreeNode temp = list.get(i);
            temp.right = list.get(i+1);
            temp.left = null;
        }
        return;
    }
}