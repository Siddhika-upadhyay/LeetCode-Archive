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
    public int maxPathSum(TreeNode root) {
        int maxValue[]=new int [1];
        maxValue[0]=Integer.MIN_VALUE;
        pathDownSum(root,maxValue);
        return maxValue[0];
    }
    public int pathDownSum(TreeNode node,int[]maxValue){
        if(node==null)return 0;
        int lh= Math.max(0,pathDownSum(node.left,maxValue));
        int rh= Math.max(0,pathDownSum(node.right,maxValue));
        maxValue[0]= Math.max(maxValue[0],lh+rh+node.val);
        return Math.max(lh,rh)+node.val;
    }

}