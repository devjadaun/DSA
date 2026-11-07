import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[] { servers[i], i });
        }
        long currTime = 0;
        for (int j = 0; j < m; j++) {
            currTime = Math.max(currTime, j);
            if (freeServers.isEmpty()) {
                currTime = Math.max(currTime, busyServers.peek()[0]);
            }
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                int[] busy = busyServers.poll();
                freeServers.offer(new int[] { busy[1], busy[2] });
            }
            int[] server = freeServers.poll();
            ans[j] = server[1];
            busyServers.offer(new int[] { (int) currTime + tasks[j], server[0], server[1] });
        }
        return ans;
    }
}