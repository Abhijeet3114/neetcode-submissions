class Solution {
    public int[] productExceptSelf(int[] nums) {

        /*
        Brute force:
            1. O(n2)
        */

        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int currProd = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j) currProd = currProd * nums[j];
            }
            result[i] = currProd;
        }
        
        return result;
    }
}  
