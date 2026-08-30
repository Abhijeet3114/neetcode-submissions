class Solution {
    public int maxArea(int[] heights) {
        
        /*
        Start with the highest breadth 
            i.e left will be 0 and right = n-1
            Record the capacity
            check if it's greater that maximum 
                update maximum
            if(left < right){
                left++;
            }
            else{
                right--;
            }
        */

        int l = 0, r = heights.length-1;

        int result = 0;

        while(l <= r){
            // capacity = breadth * Math.min(height of l, r)
            int capacity = (r - l) * Math.min(heights[r], heights[l]);
            
            // update max
            if(capacity > result){
                result = capacity;
            }

            //check other combinations
            if(heights[l] < heights[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return result;
    }
}
