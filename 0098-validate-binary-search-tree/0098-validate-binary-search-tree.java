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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBSTree(TreeNode root,Long minVal, Long maxVal){
        if(root==null)return true;
        if(root.val>=maxVal||root.val<=minVal)return false;
        return isValidBSTree(root.left, minVal, (long) root.val) &&
               isValidBSTree(root.right, (long) root.val, maxVal);
               }
}