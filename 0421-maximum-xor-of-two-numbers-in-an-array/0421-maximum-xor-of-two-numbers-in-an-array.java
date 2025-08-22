class Solution {
    //brute force time limit exceeded:
    // public int findMaximumXOR(int[] nums) {
    //     int maxX=0;
    //     int n= nums.length;
    //     for(int i=0;i<n-1;i++){
    //         for(int j=i+1;j<n;j++){
    //             maxX=Math.max(maxX,nums[i]^nums[j]);
    //         }
    //     }
    //     return maxX;
    // }
 class Node {
        Node[] links;
        Node() {
            links = new Node[2];
        }
        boolean containsKey(int bit) {
            return links[bit] != null;
        }
        Node get(int bit) {
            return links[bit];
        }
        void put(int bit, Node node) {
            links[bit] = node;
        }
    }

    class Trie {
        Node root;
        Trie() {
            root = new Node();
        }
        void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }
        int getMaxXor(int num) {
            Node node = root;
            int maxNum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    maxNum |= (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            return maxNum;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }
        int maxXor = 0;
        for (int num : nums) {
            maxXor = Math.max(maxXor, trie.getMaxXor(num));
        }
        return maxXor;
    }
}