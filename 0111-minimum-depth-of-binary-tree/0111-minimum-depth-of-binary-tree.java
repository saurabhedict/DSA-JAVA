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
//     public int minDepth(TreeNode root) {
//        if(root == null) return 0;
//        if(root.left == null && root.right == null) return 1;
       
//        int left = Integer.MAX_VALUE;
//        if(root.left != null){
//         left = minDepth(root.left);
//        }
//        int right = Integer.MAX_VALUE;
//        if(root.right != null){
//         right = minDepth(root.right);
//        }
//        return 1 + Math.min(left, right);
       
//     }
// } //DFS




class Solution {
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node ,int level){
            this.node = node;
            this.level = level;
        }
    }
    public int minDepth(TreeNode root) {
      if(root == null) return 0;
      if(root.left == null && root.right == null) return 1;
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(root, 1));
      while(!q.isEmpty()){
        Pair front = q.remove();
        TreeNode node = front.node;
        int level = front.level;
        if(node.left == null && node.right == null) return level;
        if(node.left != null) q.add(new Pair(node.left, level+1));
        if(node.right != null) q.add(new Pair(node.right, level+1));
      }
      return -1;
       
    }
}