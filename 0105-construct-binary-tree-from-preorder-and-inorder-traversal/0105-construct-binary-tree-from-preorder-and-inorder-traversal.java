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
   private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inorderIndexMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize,
                          inStart, inRootIndex - 1);
        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd,
                           inRootIndex + 1, inEnd);
        
        return root;
}
}