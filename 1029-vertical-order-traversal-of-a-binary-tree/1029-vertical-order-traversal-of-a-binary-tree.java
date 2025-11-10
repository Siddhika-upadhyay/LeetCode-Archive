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
    public void preorder(TreeNode node,int vertical,int level,  TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>nodes){
         if(node==null)return;
        if(!nodes.containsKey(vertical)){
            nodes.put(vertical,new TreeMap<>());
        }
        if(!nodes.get(vertical).containsKey(level)){
            nodes.get(vertical).put(level,new PriorityQueue<>());
        }
        nodes.get(vertical).get(level).add(node.val);
        preorder(node.left,vertical-1,level+1,nodes);
        preorder(node.right,vertical+1,level+1,nodes);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>nodes= new TreeMap<>();
        preorder(root,0,0,nodes);
       List<List<Integer>>ans= new ArrayList<>();
       for (TreeMap<Integer, PriorityQueue<Integer>> levels : nodes.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : levels.values()) {
                while (!pq.isEmpty()) {
                    col.add(pq.poll()); 
                }
            }
            ans.add(col);
        }
        return ans;
    }
}