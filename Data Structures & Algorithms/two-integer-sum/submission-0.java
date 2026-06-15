class Solution {
    public int[] twoSum(int[] nums, int target) {
        // you have target, one solution is check all pairs O(n2), then other is sort the array and use two pointers O(n logn), and then use hashset and do in O(n)

        HashMap<Integer, Integer> complimentMap = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){
            int compliment = target - nums[i];
            if(complimentMap.containsKey(compliment)){
                // search for compliment in current array
                result[0] = complimentMap.get(compliment);
                result[1] = i;
            }
            else{
                complimentMap.put(nums[i], i);
            }
        }

        return result;
    }
}
