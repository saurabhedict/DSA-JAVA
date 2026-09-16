/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp != null){
                ans = ans + temp.val + ",";
                q.add(temp.left);
                q.add(temp.right);
            }
            else ans = ans + "N" + ",";
        }
        return ans;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = null;
        int i = 0;
        int num = 0;
        if(data.charAt(i) != 'N'){
            int sign = 1;

            if(data.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            while(data.charAt(i) != ','){
                num = num*10 + (data.charAt(i) - '0');
                i++;
            }
            num = num * sign;
            i++;
            root = new TreeNode(num);
            q.add(root);
            num = 0;
        }
        else i += 2;

        while(!q.isEmpty()){
           TreeNode temp = q.remove();
            for(int k = 0; k<2; k++) {

             if(data.charAt(i) != 'N'){
                int sign = 1;
                if(data.charAt(i) == '-') {
                sign = -1;
                i++;
                }
                while(data.charAt(i) != ','){
                   num = num*10 + (data.charAt(i) - '0');
                   i++;
                }
                num = num * sign;
                i++;
                TreeNode x = new TreeNode(num);
                if(k == 0) temp.left = x;
                if(k == 1)  temp.right = x;
                q.add(x);
                num = 0;
            }
            else i += 2;
           }
           
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));