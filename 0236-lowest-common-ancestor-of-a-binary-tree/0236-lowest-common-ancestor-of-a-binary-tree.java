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
       if(root == null) return false;
       if(root == p) return true;

    //    if(root.left == null && root.right == null) return false;
    //    if(root.left == p || root.right == p) return true;
    //    else
    //    {
    //       boolean x  = isExist(root.left, p);
    //       boolean y =  isExist(root.right, p);
    //       if(x || y == true) return true;
    //       else return false;
    //    }

          return isExist(root.left, p) ||  isExist(root.right, p);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == p || root == q) return root;
         
        boolean plef =  isExist(root.left, p);
        boolean qlef =  isExist(root.left, q);

        if(plef == true && qlef == true) 
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(plef == false && qlef == false)
        {
            return lowestCommonAncestor(root.right, p, q);
        }

        
        return root; //if(plef == false && qlef == true) return root;
                     //if(plef == true && qlef == false) return root;

       
    }
}