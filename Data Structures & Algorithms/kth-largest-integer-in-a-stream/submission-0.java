class KthLargest {

    PriorityQueue<Integer> maxHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        maxHeap =  new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;
        for(int i : nums){
            maxHeap.offer(i);
        }
    }
    
    public int add(int val) {
        maxHeap.offer(val);
        int temp = k;
        int last = 0;
        ArrayList<Integer> removed = new ArrayList<>();
        while(temp > 0){
            last = maxHeap.poll();
            removed.add(last);
            temp--;
        }
        maxHeap.addAll(removed);

        return last;
    }
}
