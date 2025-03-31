class Solution {
public:
    bool isPalindrome(int x) {
        unsigned temp=x;
         unsigned rev=0;
        unsigned rem;
        if(x<0){
           return false;
        }
        while(temp!=0){
            rem=temp%10;
             rev=rem+rev*10;
            temp=temp/10;
      }
        if(rev==x){
             return true;
        }
         else{
             return false;
      }
    }
};