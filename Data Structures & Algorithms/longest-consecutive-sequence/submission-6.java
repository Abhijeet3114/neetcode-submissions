class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            numSet.add(nums[i]);
        }

        int result = 0;

        for(int i = 0; i < nums.length; i++){
            // check if it's start of the seq
            if(!numSet.contains(nums[i]-1)){
                int currLongest = 1;
                while(numSet.contains(nums[i]+currLongest)){
                    currLongest++;
                }
                result = Math.max(currLongest, result);
            }
        }
        
        return result;
    }
}
