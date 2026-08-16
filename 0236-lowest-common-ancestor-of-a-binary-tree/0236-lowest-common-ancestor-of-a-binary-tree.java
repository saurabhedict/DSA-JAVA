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
    public boolean isExist(TreeNode root, TreeNode p)
    {
       if(root == null) return false; //extra
       if(root == p) return true;
       if(root.left == null && root.right == null) return false;
       if(root.left == p || root.right == p) return true;
       else
       {
          boolean x  = isExist(root.left, p);
          boolean y =  isExist(root.right, p);
          if(x || y == true) return true;
          else return false;
       }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == p || root == q) return root;
        // if(root.left == null || root.right == null)
        // {
        //     if(root.left == null) 
        //     {
        //     if(root.right == p && ((root.right.left==q) || (root.right.right==q))) return root.right;
        //     if(root.right == q && ((root.right.left==p) || (root.right.right==p))) return root.right;
        //     root = root.right;
        //     }
        //     else
        //     {
        //     if(root.left == p && ((root.left.left==q) || (root.left.right==q))) return root.left;
        //     if(root.left == q && ((root.left.left==p) || (root.left.right==p))) return root.left;
        //     root = root.left;
        //     }
        //     return root;
        // }
         
        boolean plef =  isExist(root.left, p);
        boolean qlef =  isExist(root.left, q);

        if(plef == true && qlef == false)
        {
           return root;
        } 
        if(plef == true && qlef == true) 
        {
            root = root.left;
            return lowestCommonAncestor(root, p, q);
        }
        if(plef == false && qlef == false)
        {
            root = root.right;
            return lowestCommonAncestor(root, p, q);
        }

        
        return root; //if(plef == false && qlef == true) return root;
       
    }
}