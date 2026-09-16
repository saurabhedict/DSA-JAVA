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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        fillArray(root, list);
        return list.get(k-1);
    }
} //Inorder of BST is always Sorted : core idea