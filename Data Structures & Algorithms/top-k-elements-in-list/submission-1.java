class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>
                       ((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for(int i = 0; i < nums.length; i++){
            int key = nums[i];
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }


        // can i use min-heap
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            pq.add(new int[] {entry.getKey(), entry.getValue()});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int result[] = new int[k];

        for(int i  = 0; i < k; i++){
            int[] temp = pq.poll();
            result[i] = temp[0];
        }


        return result;
        
    }
}
