class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[]ans=new int[n];
        Stack<Integer>s1=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s1.isEmpty() && temperatures[i]>temperatures[s1.peek()])
            {
                int prev=s1.pop();
                ans[prev]=i-prev;
            }
            s1.push(i);
        }
        return ans;
    }
}