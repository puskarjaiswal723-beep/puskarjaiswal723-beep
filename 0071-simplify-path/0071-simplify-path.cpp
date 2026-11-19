class Solution {
public:
    string simplifyPath(string path) {
        stringstream ss(path);
        string word;
        stack<string> stck;
        while(getline(ss,word,'/')){
            if(word=="" || word=="."){
                continue;
            }
            else if(word==".."){
                if(!stck.empty()){
                    stck.pop();
                }
            }
            else{
                stck.push(word);
            }
        }
    
    string str;
    while(!stck.empty()){
        str="/"+stck.top()+str;
        stck.pop();
    }
    if(str==""){
        str="/";
    }
    return str;}
};