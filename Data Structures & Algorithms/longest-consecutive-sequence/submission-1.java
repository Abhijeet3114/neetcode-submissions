class Solution {
    public int longestConsecutive(int[] nums) {
        /*
            Brute force:
                sort an array
                    and check how many are there where the increasing no diff is 1
        */

        if(nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        int longest = Integer.MIN_VALUE;
        int currLong = 1;

        for(int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i-1];
            if(diff == 0){
                 continue;
            }
            else if(diff == 1){
                currLong++;
            }
            else{
                longest = Math.max(currLong, longest);
                currLong = 1;
            }
        }
        longest = Math.max(currLong, longest);

        return longest;
    }
}
