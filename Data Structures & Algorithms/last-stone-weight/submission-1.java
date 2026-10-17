class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
        
        What is needed?
        [2,3,6,2,4]
        int last = stones.length - 1;
        for(int i = 0; i <= last; i++){
            sort: 2,2,3,4,6
            int rem = stone[last] - stone[last-1];
            if(rem != 0){
                last = last-1;
                stones[last] = rem;
            }
            else{
                last = last - 2; remove both
            }

        }    

        dry run:
            last = 4
            
            i = 0
                sort : 2 2 3 4 6
                rem = 6-4 = 2
                rem != 0
                    last = 3;
                    stones = 2 3 3 2 // rem inserted at the end
                    stones needs to be cleared and reinitialized otherwise sort will consider removed element as well
            
            i = 1
                sort : 2 2 2 3
                rem = 1
                rem != 0
                    last = 2
                    stones = 2 2 1
            
            i = 2
                sort: 1 2 2
                rem = 0
                last = last - 2 = 0

        */

        ArrayList<Integer> arr = new ArrayList<>();
        int last = stones.length - 1;
        for(int i : stones){
            arr.add(i);
        }
        while(last >= 1){
            Collections.sort(arr);
            System.out.println(arr);
            int rem = arr.get(last) - arr.get(last - 1);
            if(rem == 0){
                arr.remove(last);
                arr.remove(last-1);
                last = last - 2;
            }
            else{
                arr.remove(last);
                arr.remove(last-1);
                arr.add(rem);
                last = last - 1;
            }
        }

        return arr.isEmpty() ? 0 : arr.get(0);
        
        
    }
}
