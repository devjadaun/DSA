class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer>  gmap = new HashMap<>();

        Stack<Integer> st = new Stack<>();
        for(int i= nums2.length-1;i>=0;i--){
            int num = nums2[i];

            while(st.isEmpty()==false && st.peek() <= num) st.pop();

            gmap.put(num, st.size() == 0 ? -1 : st.peek());
            st.push(num);
        }

        int n = nums1.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++)res[i] = gmap.get(nums1[i]);
        return res;
    }
}