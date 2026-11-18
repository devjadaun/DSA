class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
                sb.append(ch);
            } else if(ch == ')'){
                if(count > 0){
                    count--;
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = sb.length()-1; i >= 0; i--){
            char c = sb.charAt(i);
            if(c == '(' && count > 0){
                count--;
            } else {
                res.append(c);
            }
        }

        return res.reverse().toString();
    }
}