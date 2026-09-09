import java.util.Arrays;
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1);
        if (k == 0) {
            return nums;
        }
        int size = 2 * k + 1;
        if (size > n) {
            return avgs;
        }
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        avgs[k] = (int) (sum / size);
        for (int i = k + 1; i < n - k; i++) {
            sum += nums[i + k] - nums[i - k - 1];
            avgs[i] = (int) (sum / size);
        }
        return avgs;
    }
}