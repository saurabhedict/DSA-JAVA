class Solution {
    public boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val){
          boolean pLeft = check(p.left, q.right);
          boolean qLeft = check(p.right, q.left);
          return pLeft && qLeft;
        }
        else return false;
        
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        return check(root.left, root.right);
    }
}