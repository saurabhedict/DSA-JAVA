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
//     public void inOrder(ArrayList<Integer> list, TreeNode root){
//         if(root == null) return;
//         inOrder(list, root.left);
//         list.add(root.val);
//         inOrder(list, root.right);
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         ArrayList<Integer> list = new ArrayList<>();
//         inOrder(list, root);
//         return list;
//     }
// }



class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;
        while(true){
            if(temp != null){
                st.add(temp);
                temp = temp.left;
            }
            else{
                if(st.isEmpty()) break;
                TreeNode top = st.pop();
                list.add(top.val);
                temp = top.right;
            }
        }
        return list;
    }
}