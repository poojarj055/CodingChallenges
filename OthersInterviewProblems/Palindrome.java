class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int rev=0;
        while(x!=0){
            int r=x%10;
            rev=rev*10+r;
            x=x/10;
        }
        if(rev==Math.abs(temp)){
            return true;
        }
        else{
            return false;
        }
    }
}
