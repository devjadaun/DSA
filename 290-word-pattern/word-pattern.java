import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, Integer> charMap = new HashMap<>();
        Map<String, Integer> wordMap = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (!charMap.containsKey(c)) {
                charMap.put(c, i);
            }
            if (!wordMap.containsKey(w)) {
                wordMap.put(w, i);
            }
            
            if (!charMap.get(c).equals(wordMap.get(w))) {
                return false;
            }
        }
        
        return true;
    }
}