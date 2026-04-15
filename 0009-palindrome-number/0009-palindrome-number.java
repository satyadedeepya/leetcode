class Solution {
    public boolean isPalindrome(int x) {
        int y=x;
        int reversed=0;
        int digit;

        if(x<0) return false;

        while(Math.abs(y)>9){

            digit=y%10;

            reversed=reversed*10+digit;

            y/=10;

        }
        digit=y%10;

        reversed=reversed*10+digit;

        if(reversed!=x) return false;

        return true;

        
    } 
}