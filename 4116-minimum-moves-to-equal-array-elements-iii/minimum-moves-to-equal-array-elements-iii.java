class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        
        int total = 0;
        for (int num : nums) {
            total += (max - num);
        }
        
        return total;
    }
}