class Solution {
    public int[] productExceptSelf(int[] nums) {

        /*
        Brute force:
            1. O(n2)
        

        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int currProd = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j) currProd = currProd * nums[j];
            }
            result[i] = currProd;
        }
        
        return result;

        */


        /*
        
            1 2 4 6


            build pre arr from 1 to n using cumm prod from 0 to n-1
            pre : 1  1   2   8
            suff: 48 24  6   1  

            48 

        */

        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];

        pref[0] = 1;
        suff[nums.length-1] = 1;

        for(int i = 1; i < nums.length; i++){
            pref[i] = pref[i-1]*nums[i-1];
        }

        for(int i = nums.length-2; i >= 0; i--){
            suff[i] = suff[i+1]*nums[i+1];
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = pref[i] * suff[i];
        }

        return result;
    }
}  
