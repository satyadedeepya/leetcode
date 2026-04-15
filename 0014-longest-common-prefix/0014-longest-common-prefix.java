class Solution {
    public String helper(String a, String b){
        int n=a.length();
        int m=b.length();
        String ans="";
        int i=0;
        while(i<Math.min(n,m)){
            if(a.charAt(i)!=b.charAt(i)){
                return ans;
            }
            ans+=a.charAt(i);
            i++;
        }
        return ans;

    }
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        String ans=strs[0];

        for(int i=1;i<n;i++){
            ans=helper(ans,strs[i]);
        }
        return ans;
        
    }
}
