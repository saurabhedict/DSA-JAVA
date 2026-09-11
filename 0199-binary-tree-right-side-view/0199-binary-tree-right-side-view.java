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
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public void BFS(TreeNode root, List<Integer> ans){
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(root, 1));
      while(!q.isEmpty()){
        Pair front = q.remove();
        TreeNode node = front.node;
        int level = front.level;
        ans.add(node.val);
        if(node.right != null) q.add(new Pair(node.right, level+1));
        if(node.left != null) q.add(new Pair(node.left, level+1));
        while(!q.isEmpty() && q.peek().level == level){
            Pair temp =  q.remove();
            if(temp.node.right != null) q.add(new Pair(temp.node.right, level+1));
            if(temp.node.left != null) q.add(new Pair(temp.node.left, level+1));
        }
      }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
         BFS(root, ans);
         return ans;
    }
}