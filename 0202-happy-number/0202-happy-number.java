class Solution {
    private int findNext(int n){
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum+=rem*rem;
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=findNext(slow);
            fast=findNext(findNext(fast));
        }while(fast!=1&&fast!=slow);
        return fast==1;
    }
}