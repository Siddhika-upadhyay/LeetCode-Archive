class Solution {
    public TreeNode build(int[] postorder, int postStart, int postEnd,
                          int[] inorder, int inStart, int inEnd,
                          Map<Integer, Integer> inorderMap) {
        
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inorderMap.get(rootVal);
        int numsLeft = inRootIndex - inStart;
        
        root.left = build(postorder, postStart, postStart + numsLeft - 1,
                          inorder, inStart, inRootIndex - 1, inorderMap);
        
        root.right = build(postorder, postStart + numsLeft, postEnd - 1,
                           inorder, inRootIndex + 1, inEnd, inorderMap);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
}
