class Solution {
    public int trap(int[] height) {

        /*
            Amount of water which can be trapped at current bar

            currentBar = MinOf(max(Left Height), max(rightHeight)) 
                            - (current height)

            if currentBar < 0, then set it to 0

            For Sample Array : Input: height = [0,2,0,3,1,0,1,3,2,1]

            bar i = 0
            currentBar = MinOf(0, 3) - (0)
            currentBar = 0
            Total Capacity cumm = 0

            bar i = 1
            currentBar = MinOf(0, 3) - 2
            currentBar = 0
            Total Capacity cumm = 0

            bar i = 2
            currentBar = minOf(2,3) - 0
            currentBar = 2
            Total Capacity cumm = 2

            bar i = 3
            currentBar = min(2,3) - 3
            currentBar = 0
            Total Capacity cumm = 2

            bar i = 4
            current = min(3,3) - 1
            currentBar = 2
            Total Capacity cumm = 4

            bar i = 5
            current = min(3,3) - 0
            currentBar = 3
            Total Capacity cumm = 7

            bar i = 6
            current = min(3,3) - 1
            currentBar = 2
            Total Capacity cumm = 0

            bar i = 7
            current = min(3,2) - 3
            currentBar = -1 = 0
            Total Capacity cumm = 9

            bar i = 8
            current = min(3,1) - 2
            currentBar = -1 = 0
            TotalCapacity = 9

            bar i = 9
            current = min(3,0) - 2


            Algo:
                Create 2 two arrays
                one will store the maxHeight from left and another right height

                height =  [0, 2, 0, 3, 1, 0, 1, 3, 2, 1]
               leftMax =  [0, 0, 2, 2, 3, 3, 3, 3, 3, 3]
               rightMax = [3, 3, 3, 3, 3, 3 ,3, 2, 1, 0]
               capacity = [0, 0, 2, 0, 2, 3, 2, 0, 0, 0 ]
        */

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = 0;
        rightMax[n-1] = 0;

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }

        int result = 0;

        for(int i = 0; i < n; i++){
            int currentCapacity = Math.min(leftMax[i], rightMax[i]) - height[i];
            result = result + Math.max(currentCapacity, 0);
        }

        return result;        
    }
}
