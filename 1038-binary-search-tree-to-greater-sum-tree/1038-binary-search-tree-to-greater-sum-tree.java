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
//     int sum = 0;
//     public TreeNode bstToGst(TreeNode root) {
//         if(root == null) return null;
//         bstToGst(root.right);
//         sum += root.val;
//         root.val = sum;
//         bstToGst(root.left);
//         return root;
//     }
// }




class Solution {
    public void fillList(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;
        fillList(root.left, list);
        list.add(root);
        fillList(root.right, list);
    }
    public TreeNode bstToGst(TreeNode root) {
       ArrayList<TreeNode> list = new ArrayList<>();
       fillList(root, list);
       for(int i = list.size()-2; i>=0; i--){
            list.get(i).val += list.get(i+1).val;
       }
       return root;
    }
}