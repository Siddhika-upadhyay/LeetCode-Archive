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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
         if (root == null) return ans;
         Queue<TreeNode> q=new LinkedList<>();
         q.offer(root);
         boolean lTor=true;
         while(!q.isEmpty()){
             int s=q.size();
             List<Integer> temp=new ArrayList<>();
             for(int i=0;i<s;i++){
                 TreeNode curr=q.poll();
                 temp.add(curr.val);
                 if(curr.left!=null) q.offer(curr.left);
                 if(curr.right!=null) q.offer(curr.right);
             }
             if(!lTor){
                 Collections.reverse(temp);
             }
             lTor=!lTor;
             ans.add(temp);
         }
         return ans;
    }
}