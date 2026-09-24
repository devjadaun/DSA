class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int digitSum = 0;
            while (currentNum > 0) {
                digitSum += currentNum % 10;
                currentNum /= 10;
            }
            if (nums[i] == 0 && i == 0) {
                return 0;
            }
            if (digitSum == i) {
                return i;
            }
        }
        return -1;
    }
}