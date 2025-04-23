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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans= new ArrayList<>();
        rightView(root,0,ans);
        return ans;
    }
    public void  rightView(TreeNode node ,int level, ArrayList<Integer> ans ){
        if(node==null) return;
        if(level== ans.size()){
            ans.add(node.val);
        }
         rightView(node.right,level+1,ans);
         rightView(node.left,level+1,ans);
    }
}