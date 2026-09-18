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
    public TreeNode predecessor(TreeNode root){
        TreeNode temp = root.left;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }
    public TreeNode ParentOfPred(TreeNode root, TreeNode pred){
        if(root.left == pred) return root;
        TreeNode temp = root.left;
        while(temp.right != pred){
            temp = temp.right;
        }
        return temp;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key) root.left =  deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else{ //root.val == key
           //case 1 : leaf node
           if(root.left == null && root.right == null) return null;
           
           //case 2: has 1 child node
           else if(root.left == null || root.right == null) {
            if(root.left == null) return root.right;
            else return root.left;
           }
           
           //case 3 : has 2 child
           else{
              TreeNode pred = predecessor(root);
              TreeNode predParent = ParentOfPred(root, pred);
              if(root == predParent){
                pred.right = root.right;
                return pred;
              }
              predParent.right = pred.left;
              pred.left = root.left;
              pred.right = root.right;
              return pred;
            }
           
        }
        return root;
    }
}