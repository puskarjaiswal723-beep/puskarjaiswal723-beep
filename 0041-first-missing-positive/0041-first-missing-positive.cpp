class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        unordered_set<int> set;
        int mx=INT_MIN;
        for(int x:nums){
            mx=max(mx,x);
            set.insert(x);
        }
        int i=0;
        for( i=1;i<=mx;i++){
            if(!set.count(i)){
                return i;
            }
        }
        return i;
    }
};