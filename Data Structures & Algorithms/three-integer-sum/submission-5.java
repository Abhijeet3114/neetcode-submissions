class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
            brute force: O(n3)
                we first pick the first number
                    then reduce the target to target-firstNumber
                        now search for the pair in rest of the array


            Option 2:
                get sorted array
                pairTarget negated
                and for rest of the array use 2 pointers to check if pairTargetNegated summing up pair exists

        */

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int pairTarget = -nums[i];
            
            for(int l = i+1, r = nums.length-1; l < r;){
                int currSum = nums[l] + nums[r];
                if(currSum == pairTarget){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                    r--;
                }
                else if(currSum < pairTarget){
                    l++;
                }
                else{
                    r--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
