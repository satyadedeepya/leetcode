class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(a==Integer.MAX_VALUE && words[(startIndex+i)%n].equals(target)){
                a=i;
            }
            if(b==Integer.MAX_VALUE && words[(startIndex-i+n)%n].equals(target)){
                b=i;
            }
            if(a!=Integer.MAX_VALUE && b!=Integer.MAX_VALUE) break;
        }
        int res=Math.min(a,b);

        if(res == Integer.MAX_VALUE) return -1;

        return res;


    }
}