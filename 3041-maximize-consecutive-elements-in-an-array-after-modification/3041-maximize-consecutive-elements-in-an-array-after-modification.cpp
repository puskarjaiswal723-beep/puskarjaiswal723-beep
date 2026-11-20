
class Solution {
public:
    int maxSelectedElements(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int dp0 = 1, dp1 = 1;
        int ans = 1;

        for(int i = 1; i < nums.size(); i++) {
            int diff = nums[i] - nums[i-1];

            if(diff == 0) {
                dp1 = dp0 + 1;
            }
            else if(diff == 1) {
                dp0++;
                dp1++;
            }
            else if(diff == 2) {
                dp0 = dp1 + 1;
                dp1 = 1;
            }
            else {
                dp0 = 1;
                dp1 = 1;
            }

            ans = max({ans, dp0, dp1});
        }

        return ans;
    }
};
