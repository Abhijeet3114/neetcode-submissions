class Solution {
    public boolean hasDuplicate(int[] nums) {
        // one option is using hashset, keep adding is there's duplicate then return has duplicate
        HashSet<Integer> seen = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(!seen.contains(nums[i])){
                seen.add(nums[i]);
            }
            else{
                return true;
            }
        }

        return false;
    }
}