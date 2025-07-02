class Solution {
    public int candy(int[] ratings) {
          int n = ratings.length;
        if (n == 0) return 0;

        int sum = 1;
        int up = 1;     
        int down = 0;  
        int peak = 1;    
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                sum += up;
            } else if (ratings[i] == ratings[i - 1]) {
                up = peak = 1;
                down = 0;
                sum += 1;
            } else {  
                down++;
                up = 1;
                sum += down;
                if (down >= peak) {
                    sum += 1;
                }
            }
        }

        return sum;
        // int sum=0,i=1;
        // int n= ratings.length;
        // while(i<n){
        //     while(ratings[i]==ratings[i-1]){
        //         sum+=1;
        //         continue;
        //     }
        //    int  peak=1;
        //     while(i<n && ratings[i]>ratings[i-1]){
        //         peak+=1;
        //          sum+=peak;
        //          i++;
        //          continue;

        //     }
        //     int down=1;
        //     while(i<n && ratings[i]<ratings[i-1]){
        //       sum+=down;
        //       i++;
        //       down++;
        //     }
        //     if(down>peak){
        //         sum=sum+(down-peak);
        //     }
    
        // }
        //  return sum;
    }
}