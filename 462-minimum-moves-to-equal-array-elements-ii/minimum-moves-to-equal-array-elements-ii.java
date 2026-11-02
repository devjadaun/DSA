import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int med = nums[nums.length / 2];
        int move = 0;
        
        for (int num : nums) {
            move += Math.abs(num - med);
        }
        
        return move;
    }
}