class Solution {
    public int trap(int[] height) {
        /*
            At any point we want to check leftBoundary and rightBoundary
            and add to the capacity Min(leftBoundary, rightBoundary) - height[i]

            When we do it with 2 pointers

            when leftBoundary is min then we don't care what the right boundary is
            the max that we can store is upto leftBoundary height

            When rightBoundary is min, then we don't care what the left boundary is because
            the max that we can store on right side is upto rightBoundary. Anythin more than 
            that will spill over


            0 2 0 3
            l     r ==> lmax < rmax, 0 - 0 = 0, lmax = 0, l++
              l   r ==> lmax < rmax, 0 - 2 = -2, lmax = 2, l++
                l r ==> lmax < rmax, 2 - 0 = 2, lmax = 2, l++
                 

            

        */

        int l = 0, r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int totalCapacity = 0;
        while(l <= r){
            if(leftMax <= rightMax){
                totalCapacity += Math.max(0, leftMax - height[l]);
                leftMax = Math.max(height[l], leftMax);
                l++;
            }
            else{
                totalCapacity += Math.max(0, rightMax - height[r]);
                rightMax = Math.max(height[r], rightMax);
                r--;
            }
        }

        return totalCapacity;
    }
}
