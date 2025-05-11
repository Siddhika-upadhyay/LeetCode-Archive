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
     public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return helper(root);
        TreeNode dummy = root;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key); 
        }
        return dummy;
    }
    public TreeNode helper(TreeNode root){
     if(root.left==null)return root.right;
     else if(root.right==null)return root.left;
     TreeNode rightChild= root.right;
     TreeNode lastRight=lastRight(root.left);
     lastRight.right=rightChild;
     return root.left;
    }
    public TreeNode lastRight(TreeNode root){
     if(root.right==null)return root;
     return lastRight(root.right);
    }
}