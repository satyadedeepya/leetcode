class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int[] prefix = new int[n];
        prefix[0]=nums[0];

        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int j=0;j<n;j++){
            int left = j;
            int right = n-1-j;
            int leftSum = (left * nums[j]) - (prefix[j] - nums[j]);
            int rightSum = (prefix[n-1] - prefix[j])-(right * nums[j]);

            result[j] = leftSum + rightSum;

        }

        return result;
    }
}