class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        Bruteforce:
            Sort array n log n
            find using two pointers find the longest consecutive seq n
        */

        if(nums.length <= 1){
            return nums.length;
        }
        
        Arrays.sort(nums);

        int l = 0, r = 1;
        int result = 0;
        while(r < nums.length){
            if(Math.abs(nums[r] - nums[r-1]) == 0){
                l++;
            }
            if(Math.abs(nums[r] - nums[r-1]) > 1){
                result = Math.max(r-l, result);
                l = r;
            }
            
            r++;
        }
        result = Math.max(r-l, result);

        return result;
    }
}
 