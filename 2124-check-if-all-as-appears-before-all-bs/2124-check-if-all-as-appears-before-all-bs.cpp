class Solution {
public:
    bool checkString(string s) {
       bool foundb=false;
        for(int i=0;i<s.length();i++){
            if(s[i]=='a'){
                if(foundb){
                    return false;
                }
            
            }
            else{
                foundb=true;
            }
        }
    return true;}
};