class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;

        while(l < r){
            int mid = l + (r - l)/2; // 0 1 2 3 4 5 ==> r+l - l = 5+3 - 3 
            if(target == nums[mid]){
                return mid;
            }
            else if(nums[mid] < target){
                l++;
            }
            else{
                r--;
            }
        }

        return -1;
    }
}
