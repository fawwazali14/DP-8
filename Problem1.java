class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int c = 0;
        int[] dp = new int[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1 || i == n-2){
                dp[i] = 0;
            }
            else if(nums[i]-nums[i+1]==nums[i+1]-nums[i+2]){
                dp[i] = dp[i+1]+1;
            }
        }


        for(int j=0;j<n;j++){
            c = c + dp[j];
        }

        return c;

        
    }
}