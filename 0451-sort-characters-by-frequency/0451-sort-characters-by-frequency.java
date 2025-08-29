class Solution {
    public String frequencySort(String s) {
     HashMap<Character,Integer>mpp= new HashMap<>();
     for(char ch: s.toCharArray()){
        mpp.put(ch,mpp.getOrDefault(ch,0)+1);
     }
     PriorityQueue<Character>pq= new PriorityQueue<>(
        (a,b)->mpp.get(b)-mpp.get(a));
        pq.addAll(mpp.keySet());
        
        StringBuilder str= new StringBuilder();
        while(!pq.isEmpty()){
            char ch= pq.poll();
            int freq= mpp.get(ch);
            for(int i=0;i<freq;i++){
                str.append(ch);
            }
        }
        return str.toString();
    }
}