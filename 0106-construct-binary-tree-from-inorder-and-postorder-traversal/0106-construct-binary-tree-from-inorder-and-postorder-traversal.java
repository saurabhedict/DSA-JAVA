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
//      int idx;
//     public TreeNode solve(int[] postorder, int[] inorder, int start, int end){
//         if(start > end) return null;
//         int rootVal = postorder[idx];
//         int i = start;
//         for(;i<=end; i++){
//             if(inorder[i] == rootVal) break;
//         }
//         idx--;


//         TreeNode root = new TreeNode(rootVal);
//         root.right = solve(postorder, inorder,i+1, end);
//         root.left = solve(postorder, inorder,start,i-1);
//         return root;
//     }
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         int n =  postorder.length;
//         idx = n-1;
//         return solve(postorder,inorder, 0, n-1);
//     }
// }



// class Solution {
//     public TreeNode solve(int[] postorder, int[] inorder, int startIn, int endIn, int startPo, int endPo){
//         if(startIn > endIn) return null;
//         if(startPo > endPo) return null;
//         int rootVal = postorder[endPo];
//         int i = startIn;
//         for(;i<=endIn; i++){
//             if(inorder[i] == rootVal) break;
//         }

//         // int n = startPost-endPost+1;
//         int left = i-startIn;
//         int right = endIn-i;

//         TreeNode root = new TreeNode(rootVal);
//         root.left = solve(postorder, inorder, startIn, i-1, startPo, startPo+left-1);
//         root.right = solve(postorder, inorder, i+1, endIn, endPo-right, endPo-1);
//         return root;
//     }
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         int n =  postorder.length;
//         return solve(postorder,inorder, 0, n-1, 0, n-1);
//     }
// }




class Solution {
    public TreeNode solve(int[] postorder, int[] inorder, int startIn, int endIn, int startPo, int endPo){
        if(startIn > endIn) return null;
        if(startPo > endPo) return null;
        int rootVal = postorder[endPo];
        int i = startIn;
        for(;i<=endIn; i++){
            if(inorder[i] == rootVal) break;
        }

        // int n = startPost-endPost+1;
        int left = i-startIn;
        int right = endIn-i;

        TreeNode root = new TreeNode(rootVal);
        root.left = solve(postorder, inorder, startIn, i-1, startPo, startPo+left-1);
        root.right = solve(postorder, inorder, i+1, endIn, startPo+left, endPo-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n =  postorder.length;
        return solve(postorder,inorder, 0, n-1, 0, n-1);
    }
}