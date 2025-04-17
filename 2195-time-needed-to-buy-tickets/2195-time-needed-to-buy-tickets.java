class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count=0;
         Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            queue.offer(i);
        }
        while(!queue.isEmpty()){
           int i=queue.poll();
           if(tickets[i]>0){
            tickets[i]--;
            count++;
           }
           if(tickets[i]>0){
            queue.offer(i);
           }
           if(i==k&&tickets[i]==0){
            return count;
           }
        }
  return count;
    }
}