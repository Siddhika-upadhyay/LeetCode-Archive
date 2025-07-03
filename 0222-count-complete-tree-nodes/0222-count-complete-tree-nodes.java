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
    public int depth(TreeNode node,boolean isLeft){
        int depth=0;
        while(node!=null){
            depth++;
            node=isLeft?node.left:node.right;
        }
        return depth;
    }
    public int countNodes(TreeNode root) {
        int leftNode= depth(root,true);
        int rightNode=depth(root,false);
        if(leftNode==rightNode)return (1<<leftNode)-1;
        else 
            return 1+countNodes(root.left)+countNodes(root.right);
        
    }
}