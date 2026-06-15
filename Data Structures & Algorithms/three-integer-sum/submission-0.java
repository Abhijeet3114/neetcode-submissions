class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
            brute force: O(n3)
                we first pick the first number
                    then reduce the target to target-firstNumber
                        now search for the pair in rest of the array

        */

        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            int pairTarget = -nums[i];
            System.out.println("pairTarget: "+ pairTarget);
            for(int j = i+1; j < nums.length; j++){
                int compliment = pairTarget - nums[j];
                System.out.println("compliment: "+ pairTarget);
                for(int k = j+1; k < nums.length; k++){
                    if(nums[k] == compliment){
                        List<Integer> list = new ArrayList<>();
                        System.out.println("Here you go"+i+" ,"+j+", "+k);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        result.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
