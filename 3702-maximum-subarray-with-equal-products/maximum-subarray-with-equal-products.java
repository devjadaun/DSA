class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long prod = 1;
            long gcd = 0;
            long lcm = 1;
            for (int j = i; j < n; j++) {
                long x = nums[j];
                prod *= x;
                gcd = (gcd == 0) ? x : gcd(gcd, x);
                lcm = lcm(lcm, x);
                if (prod == lcm * gcd) {
                    ans = Math.max(ans, j - i + 1);
                }
                if (prod > 2520L * gcd * lcm) {
                    break;
                }
            }
        }
        return ans;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}