class Solution {
    public int maxArea(int[] heights) {
        /*
            One way is: pick one start at a time
                and iteratively choose i+1 to n end 

            Do same for all elements and keep track of max

            1 7 2 5 4 7 3 6

        */

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length - 1; i++){
            int currStartCapacity = 0;
            for(int j = i+1; j < heights.length; j++){
                currStartCapacity = Math.max(currStartCapacity, Math.min(heights[i], heights[j]) * (j-i));
            }
            max = Math.max(currStartCapacity, max);
        }

        return max;
    }
}
