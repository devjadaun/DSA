class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> st = new Stack<>();
        
        for (char sn : s.toCharArray()) {
            if (sn == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(sn);
            }
        }
        
        for (char sn : t.toCharArray()) {
            if (sn == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(sn);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        StringBuilder so = new StringBuilder();
        
        while (!stack.isEmpty()) {
            char sn = stack.pop();
            sb.append(sn);
        }
        
        while (!st.isEmpty()) {
            char sn = st.pop();
            so.append(sn);
        }
        
        String news = new String(sb);
        String newt = new String(so);
        return news.equals(newt);
    }
}