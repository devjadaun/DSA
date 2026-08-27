class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int n = s.length();
        StringBuilder prefix = new StringBuilder();
        int i = 0;
        while (i < n && freq[target.charAt(i) - 'a'] > 0) {
            char ch = target.charAt(i);
            freq[ch - 'a']--;
            prefix.append(ch);
            i++;
        }
        if (i < n) {
            int t = target.charAt(i) - 'a';
            for (int j = t + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    prefix.append((char) ('a' + j));
                    freq[j]--;
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            prefix.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }
                    return prefix.toString();
                }
            }
        }
        for (int pos = prefix.length() - 1; pos >= 0; pos--) {
            char removed = prefix.charAt(pos);
            freq[removed - 'a']++;
            int t = target.charAt(pos) - 'a';
            for (int j = t + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    prefix.setLength(pos);
                    prefix.append((char) ('a' + j));
                    freq[j]--;
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            prefix.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }
                    return prefix.toString();
                }
            }
        }
        return "";
    }
}