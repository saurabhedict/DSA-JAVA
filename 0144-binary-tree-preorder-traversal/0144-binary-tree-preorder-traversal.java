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
//     public void preOrder(ArrayList<Integer> list, TreeNode root){
//         if(root == null) return;
//         list.add(root.val);
//         preOrder(list, root.left);
//         preOrder(list, root.right);
//     }
//     public List<Integer> preorderTraversal(TreeNode root) {
//         ArrayList<Integer> list = new ArrayList<>();
//         preOrder(list, root);
//         return list;
//     }
// }



class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st =  new Stack<>();
        if(root != null) st.add(root);
        while(!st.isEmpty()){
            TreeNode temp =  st.pop();
            list.add(temp.val);
            if(temp.right != null)st.add(temp.right);
            if(temp.left != null) st.add(temp.left);
        }
        return list;
    }
}