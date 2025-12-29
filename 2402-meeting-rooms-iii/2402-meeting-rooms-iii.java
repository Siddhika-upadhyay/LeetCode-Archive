
class Solution {
    public int mostBooked(int n,int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> availableRooms=new PriorityQueue<>();
        for(int i=0;i<n;i++) availableRooms.offer(i);
        PriorityQueue<long[]> busyRooms=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return Long.compare(a[1],b[1]);
            return Long.compare(a[0],b[0]);
        });
        int[] roomMeetingCount=new int[n];
        for(int[] meeting:meetings) {
            int start=meeting[0],end=meeting[1];
            while(!busyRooms.isEmpty()&&busyRooms.peek()[0]<=start) {
                availableRooms.offer((int)busyRooms.poll()[1]);
            }
            if(!availableRooms.isEmpty()) {
                int room=availableRooms.poll();
                roomMeetingCount[room]++;
                busyRooms.offer(new long[]{end,room});
            } else {
                long[] earliest=busyRooms.poll();
                long newStart=earliest[0];
                int room=(int)earliest[1];
                roomMeetingCount[room]++;
                busyRooms.offer(new long[]{newStart+(end-start),room});
            }
        }
        int maxMeetings=0,roomWithMax=0;
        for(int i=0;i<n;i++) {
            if(roomMeetingCount[i]>maxMeetings) {
                maxMeetings=roomMeetingCount[i];
                roomWithMax=i;
            }
        }
        return roomWithMax;
    }
}
