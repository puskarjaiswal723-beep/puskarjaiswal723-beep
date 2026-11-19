class Solution {
public:
    string decodeString(string s) {
        stack<string> stckr;
        stack<int> stck;
        int n=0;
        string str="";
        for(int i=0;i<s.length();i++){
            if(isdigit(s[i])){
                cout<<"1";
                n=n*10+s[i]-'0';
            }
            else if(isalpha(s[i])){
                cout<<"12";
                str=str+s[i];
            }
            else if(s[i]=='['){
                cout<<"123";
                stck.push(n);
                n=0;
                stckr.push(str);
                str="";
            }
            else{
                cout<<"1";
                int t=stck.top();
                stck.pop();
                string prev=stckr.top();
                stckr.pop();
                string temp="";
                for(int i=0;i<t;i++){
                    temp+=str;
                }
                str=prev+temp;
            }
        }
  return str;  }
};