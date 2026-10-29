class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<t.length()){
             if(j==s.length()){
                    return true;
                }
            if(s.charAt(j)==t.charAt(i)){
                j++;
            }
            i++;
        }
        return j==s.length();
    }
}