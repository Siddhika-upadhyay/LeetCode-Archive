class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cnt5= 0,cnt10=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5)cnt5++;
            else if(bills[i]==10){
                if(cnt5==0)return false;
                cnt5--;
                cnt10++;
            }
            else{
              if(cnt5==0)return false;
               else  if(cnt10==0){
                if(cnt5>=3){
                    cnt5-=3;
                }
                else return false;
              }
              else{
                cnt5--;
                cnt10--;
              }
            }
        }
        return true;
    }
}