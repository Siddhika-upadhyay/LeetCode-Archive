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
    public TreeNode build (int []preorder,int preStart,int preEnd,int []inorder , int inStart,int inEnd,Map<Integer,Integer>inorderMap){
        if(preStart>preEnd||inStart>inEnd)return null;
        TreeNode root=new TreeNode(preorder[preStart]);
        int inRoot= inorderMap.get(root.val);
        int numsLeft= inRoot-inStart;
         
        root.left= build(preorder,preStart+1,preStart+numsLeft,inorder,inStart,
        inRoot-1,inorderMap);
        root.right= build(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,inorderMap);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,  
        inorderMap);
    }
}