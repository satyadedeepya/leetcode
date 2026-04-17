class Solution {
    public int reverse(int x){
        int digit;
        int reversed=0;
        while(Math.abs(x)>9){
            digit=x%10;
            reversed=reversed*10+digit;
            x/=10;
        }
        digit=x%10;
        reversed=reversed*10+digit;
        return reversed;

    }
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        for(int j=0;j<n;j++){
            int r = reverse(nums[j]);
            // nums[j] presnt element
            // we should find i such that i<j and reverse(nums[i])==nums[j]
            if(hmap.containsKey(nums[j])){
                ans = Math.min(ans,Math.abs(j-hmap.get(nums[j])));
            }
            hmap.put(r,j);
        }
        if(ans==Integer.MAX_VALUE) return -1;
        
        
        // 12 21 45 33 54
        
        // 1st iteration 
        // hmap is empty
        // r = 21, nums[j]=12
        // hmap.contains(12) => false because is empty
        // update hmap => (21,0)
        
        // 2nd iteration
        // hamp => (21,0)
        // nums[j]=21,r = 12
        // hmap.contains(21) => ans = min(ans, 1-0) => ans = 1;
        // update hamp => (21,0) (12,1)
        
        return ans;
    }
}