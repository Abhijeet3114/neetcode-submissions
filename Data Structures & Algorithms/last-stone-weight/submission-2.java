class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones){
            maxHeap.offer(i);
        }

        while(maxHeap.size() >= 2){
            int rem = maxHeap.poll() - maxHeap.poll();
            if(rem != 0){
                maxHeap.offer(rem);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();

    }
}
