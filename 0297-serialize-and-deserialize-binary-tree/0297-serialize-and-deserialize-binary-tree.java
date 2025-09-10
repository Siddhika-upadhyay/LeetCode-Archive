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
private static final String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
         helperS(root,sb);
        return sb.toString();
    }

 public void helperS(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("null").append(SEP);
            return;
        }
        sb.append(node.val).append(SEP);
        helperS(node.left,sb);
        helperS(node.right,sb);
 }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]tokens= data.split(SEP);
        Queue<String> queue= new LinkedList<>();
        for(String token:tokens){
                queue.offer(token);
        }
        return helperD(queue);
    }
    public TreeNode helperD(Queue<String>queue){
        String token= queue.poll();
        if(token.equals("null")) return null;
        TreeNode node= new TreeNode(Integer.parseInt(token));
        node.left=helperD(queue);
        node.right=helperD(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));