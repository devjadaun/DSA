class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int type1 = -1, type2 = -1;
        int currentLength = 0;
        int countB = 0;
        for (int fruit : fruits) {
            if (fruit == type1 || fruit == type2) {
                currentLength++;
            } else {
                currentLength = countB + 1;
            }
            if (fruit == type2) {
                countB++;
            } else {
                countB = 1;
                type1 = type2;
                type2 = fruit;
            }
            maxFruits = Math.max(maxFruits, currentLength);
        }
        return maxFruits;
    }
}