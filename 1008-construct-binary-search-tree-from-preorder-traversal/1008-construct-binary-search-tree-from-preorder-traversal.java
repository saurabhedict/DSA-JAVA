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
    int i = 0;
    public int find(int[] arr, int n){
        int i = 0;
        for(; i<arr.length; i++){
            if(arr[i] == n) break;
        }
        return i;
    }
    public TreeNode solve(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        int ele = preorder[i];
        TreeNode root = new TreeNode(ele);
       
        int idx = find(inorder, ele);
        i++;
        
        root.left = solve(preorder, inorder, start, idx-1);
        root.right = solve(preorder, inorder, idx+1, end);
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        return solve(preorder, inorder, 0, inorder.length-1);
    }
}