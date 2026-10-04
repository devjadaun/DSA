class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmin = Math.max(0, cmin - 1);
                cmax--;
            } else { 
                cmin = Math.max(0, cmin - 1); 
                cmax++; 
            }
            if (cmax < 0) {
                return false;
            }
        }
        return cmin == 0;
    }
}