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
    public int solve(TreeNode root, long targetSum){
       int count = 0;
       if(root == null) return count;
       targetSum = targetSum-root.val;
       if(targetSum == 0) count++;

       int left = solve(root.left, targetSum);
       int right = solve(root.right, targetSum);

       count = count + left + right;
       return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
       if(root == null) return 0;
       int countFromRoot =   solve(root, targetSum);
       int countFromLeft = pathSum(root.left, targetSum);
       int countFromRight = pathSum(root.right, targetSum);
       return (countFromRoot + countFromLeft + countFromRight);

    }
} //not a good solution in wors case TC : O(N2) and SC : O(N)
//we can solve it using O(N) TC and O(N) SC : Using hashmap, and prefixSum