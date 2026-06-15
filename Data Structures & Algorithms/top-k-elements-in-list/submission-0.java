class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use hashmap for frequency count
        // from the hashmap get the values in reverseOrder and get the keys where value is = 

        HashMap<Integer, Integer> freqCounter = new HashMap<>();

        // build freqMap
        for(int i = 0; i < nums.length; i++){
            if(freqCounter.containsKey(nums[i])){
                freqCounter.put(nums[i], freqCounter.get(nums[i])+1);
            }
            else{
                freqCounter.put(nums[i], 1);
            }
        }

        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : freqCounter.entrySet()){
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((a,b) -> b[0] - a[0]); // sort in desc

        int[] result = new int[k];
        for(int i =0; i < k; i++){
            result[i] = arr.get(i)[1];
        }
        return result;
    }
}
