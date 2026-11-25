
import java.util.*;

class Solution {

    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;
    static final long BASE1 = 911382323L;
    static final long BASE2 = 972663749L;

    long[] h1, h2, p1, p2;
    int n;

    void preprocess(int[] nums) {
        n = nums.length;

        h1 = new long[n + 1];
        h2 = new long[n + 1];

        p1 = new long[n + 1];
        p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {

            h1[i + 1] = (h1[i] * BASE1 + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + nums[i]) % MOD2;

            p1[i + 1] = (p1[i] * BASE1) % MOD1;
            p2[i + 1] = (p2[i] * BASE2) % MOD2;
        }
    }

    long getHash(int l, int r) {

        int len = r - l;

        long a = (h1[r] - h1[l] * p1[len] % MOD1 + MOD1) % MOD1;

        long b = (h2[r] - h2[l] * p2[len] % MOD2 + MOD2) % MOD2;

        return a * MOD2 + b;
    }

    boolean check(int len) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {

            long hash = getHash(i, i + len);

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int freq : map.values()) {
            if (freq == 1) {
                return true;
            }
        }

        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {

        preprocess(nums);

        int low = 1;
        int high = n;

        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }
}
