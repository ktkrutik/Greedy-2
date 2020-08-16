// Time Complexity : O(n) --> where n is the length of input tasks
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (621): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // edge case
        if (tasks == null || tasks.length == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; int maxCount = 0;
        for (char task : tasks) {
            int count = map.getOrDefault(task, 0);
            maxFreq = Math.max(maxFreq, count + 1);
            map.put(task, count + 1);
        }
        
        for (char task : map.keySet()) {
            if (map.get(task) == maxFreq) maxCount++;
        }
        
        int partitions = maxFreq - 1;
        int emptyTasks = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idleTasks = Math.max(0, (emptyTasks - pendingTasks));
        
        return idleTasks + tasks.length;
    }
}