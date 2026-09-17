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
    public void fillList(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        fillList(root.left, list);
        list.add(root.val);
        fillList(root.right, list);
    }

    public int mid(int lo, int hi){
        int mid = lo + (hi-lo)/2;
        return mid;
    }

    public TreeNode solve(int[] nums, int low, int high){
       if(low>high) return null;
       int mid = mid(low, high);
       TreeNode root = new TreeNode(nums[mid]);
       root.left = solve(nums, low, mid-1);
       root.right = solve(nums, mid+1, high);
       return root;

    }
    public int[] toArray(ArrayList<Integer> list){
       int n = list.size();
       int[] arr  = new int[n];
       for(int i = 0; i<n; i++){
        arr[i] = list.get(i);
       }
       return arr;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        fillList(root, list);
        int[] arr = toArray(list);
        return solve(arr, 0, arr.length-1);
    }
}