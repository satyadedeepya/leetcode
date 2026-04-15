class Solution {
    public String convert(String s, int numRows) {
        String[] str=new String[numRows];
        int j=0;
        int step=1;
        for(int i=0;i<numRows;i++){
            str[i]="";
        }
        if(numRows==1) return s;
        for(int i=0;i<s.length();i++){
            str[j]+=s.charAt(i);
            if(j==0) step=1;
            if(j==numRows-1 ) step=-1;
            j+=step;
        }
        String ans="";
        for(int i=0;i<numRows;i++){
            ans+=str[i];
        }
        return ans;
        
    }
}