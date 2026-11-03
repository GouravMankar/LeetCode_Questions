class Solution {
    private boolean isPrime(int val){
       if(val<=1){
        return false;
       }
        for(int i=2;i<= Math.sqrt(val);i++){
            if(val%i==0){
                return false;
            }
        }
        return true;
    }
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int item : nums) {
         map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for(Integer key:map.keySet()){
            int val=map.get(key);
            if(isPrime(val)){
                return true;
            }
        }
        return false;
    }
}