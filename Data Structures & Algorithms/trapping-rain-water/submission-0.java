class Solution {
    public int trap(int[] height) {
        /*
            At current index check 
                1. what's the highest left boundary
                2. what's the right boundary
            
            Then use the below
                get the min(left and right boundary) - current[height]
                and add it to overall waterCapacity if positive
        */

        int[] leftBoundary = new int[height.length+1];
        int[] rightBoundary = new int[height.length+1];
        leftBoundary[0] = 0;
        rightBoundary[height.length] = 0;
        for(int i = 1; i < height.length+1; i++){
            leftBoundary[i] = Math.max(leftBoundary[i-1], height[i-1]);
        }

        for(int i = height.length-1; i >= 0; i--){
            rightBoundary[i] = Math.max(rightBoundary[i+1], height[i]);
        }

        int result = 0;
        for(int i = 0; i < height.length; i++){
            result += Math.max(0, Math.min(leftBoundary[i], rightBoundary[i]) - height[i]);
        }

        return result;
    }
}
