// Time Complexity : O(n) -- where n is the length of input ratings array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (135): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        // base case
        if (ratings == null || ratings.length == 0) return 0;
        
        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        // forward pass
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) candies[i] = candies[i - 1] + 1;
        }
        
        // backward pass
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        
        int sum = 0;
        for (int el : candies) sum += el;
        return sum;
    }
}