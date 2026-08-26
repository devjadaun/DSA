class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            int j = i + 3;
            String sb = s.substring(i, j);
            if (sb.charAt(0) != sb.charAt(1) &&
                sb.charAt(1) != sb.charAt(2) &&
                sb.charAt(0) != sb.charAt(2)) {
                count++;
            }
        }
        return count;
    }
}