class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==0)return new int[0][0];

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start0=intervals[0][0];
        int end0=intervals[0][1];
        int start1,end1;
        List<int[]>ans=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            start1=intervals[i][0];
            end1=intervals[i][1];
            if(end0>=start1){
                end0=Math.max(end0,end1);
                continue;
            }
            ans.add(new int[]{start0,end0});
            start0=start1;
            end0=end1;
        }
        ans.add(new int[]{start0,end0});
        return ans.toArray(new int[ans.size()][]);
    }
}