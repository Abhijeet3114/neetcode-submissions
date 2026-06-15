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
            HashSet<Integer> seen = new HashSet<>();
            for(int j = i+1; j < nums.length; j++){
                int compliment = pairTarget - nums[j];
                if(seen.contains(compliment)){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(compliment);
                    result.add(list);
                }
                else{
                    seen.add(nums[j]);
                }
            }
        }

        return new ArrayList<>(result);
    }
}
