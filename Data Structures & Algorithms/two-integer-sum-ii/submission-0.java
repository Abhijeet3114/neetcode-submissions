class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
            Brute force is pick one number and check with all other if that form target
            Other is 2 pointers, l and r, if l + r == target then good, if l+r < target, we need larger number hence l++, else r--
        */

        for(int l = 0, r = numbers.length-1; l < r;){
            int sum = numbers[l]+numbers[r];
            if(sum == target){
                return new int[]{l+1,r+1};
            }
            else if(sum < target){
                l++;
            }
            else{
                r--;
            }
        }

        return new int[]{};
    }
}
