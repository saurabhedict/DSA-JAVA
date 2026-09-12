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
    public void PreOrder(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> temp){
        if(root == null) return;
        targetSum = targetSum - root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
           temp.add(root.val);
           ans.add(new ArrayList<>(temp));
           temp.remove(temp.size() - 1);
           return;
        }
       temp.add(root.val);
       PreOrder(root.left, targetSum, ans, temp);
       PreOrder(root.right, targetSum, ans, temp);
       temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> temp = new ArrayList<>();
        PreOrder(root, targetSum, ans, temp);
        return ans;
    }
}