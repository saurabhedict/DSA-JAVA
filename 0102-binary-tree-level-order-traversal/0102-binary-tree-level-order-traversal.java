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
    public class pair{
        TreeNode node;
        int level;
        pair(TreeNode root, int level){
            this.node = root;
            this.level = level;
        }
    }
    public int level(TreeNode root){
        if(root == null) return 0;
        int left = level(root.left);
        int right  = level(root.right);
        return 1 + Math.max(left, right);
    }
    public void fillAnswer(TreeNode root, List<List<Integer>> ans){
        Queue<pair> q = new LinkedList<>();
        if(root != null) q.add(new pair(root, 0));
        while(!q.isEmpty()){
            pair front = q.remove();
            TreeNode temp = front.node;
            int level = front.level;
            ans.get(level).add(temp.val);
            if(temp.left != null) q.add(new pair(temp.left, level+1));
            if(temp.right != null) q.add(new pair(temp.right, level+1));

        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = level(root);
        for(int i = 0; i<lvl; i++){
            List<Integer> temp = new ArrayList<>();
            ans.add(temp);
        }
        fillAnswer(root, ans);
        return ans;

    }
}