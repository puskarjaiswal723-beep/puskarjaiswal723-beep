class Solution {
public:
    int minimumDeletions(string s) {
        int counta=0;
        for(char ch:s){
            if(ch=='a'){
                counta++;
            }
        }
        int del=counta;
        int countb=0;
        for(char ch:s){
            if(ch=='b'){
                countb++;
            }
            else{
                counta--;
            }
            del=min(del,countb+counta);
        }
    return del;}
};