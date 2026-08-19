import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            int mask = map.getOrDefault(row, 0);
            mask |= (1 << col);
            map.put(row, mask);
        }
        int answer = (n - map.size()) * 2;
        int left  = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        for (int mask : map.values()) {
            boolean leftFree = (mask & left) == 0;
            boolean middleFree = (mask & middle) == 0;
            boolean rightFree = (mask & right) == 0;
            if (leftFree && rightFree) {
                answer += 2;
            }
            else if (leftFree || middleFree || rightFree) {
                answer += 1;
            }
        }
        return answer;
    }
}