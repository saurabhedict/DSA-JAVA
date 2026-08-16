class Solution {
public boolean search(TreeNode root, TreeNode p) {
    if (root == null) return false;
    if(root.val == p.val) return true;

    boolean left = search(root.left, p);
    boolean right = false;
    if(left == false)  right = search(root.right, p);
    return (left || right);

    
}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val == root.val || q.val ==root.val) return root;
        boolean pleft  = search(root.left, p);
        boolean qleft = search(root.left, q);
        if(pleft == true && qleft == true){
            root = root.left;
            return lowestCommonAncestor(root, p, q);
        }
        else if(pleft == false && qleft == false) {
            root = root.right;
            return lowestCommonAncestor(root, p, q);
        }
        return root;
    }
}