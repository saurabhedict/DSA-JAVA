/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode findNode(TreeNode root, int p, int q){
        if(root.val == p || root.val == q) return root;
        if(root.val > p && root.val < q || root.val < p && root.val > q) return root;
        if(root.val > p && root.val > q) return findNode(root.left, p, q);
        if(root.val < p && root.val < q) return findNode(root.right, p, q);
        return null;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root.val == p.val || root.val  == q.val) return root;
       TreeNode ans = findNode(root, p.val, q.val);
       return ans;
        
    }
}