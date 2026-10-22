class Solution {
    public int findDuplicate(int[] nums) {

        /*
        nums
        numbers array
            - not sorted
            - contains all distinct elements except one repeated integer
            - We need to identify the repeated integer
            - n = nums.length - 1
        
        One way: Time Complexity O(n), space O(n)
            Maintain a set/ auxiliary array of size length
            and start iterating nums
                check this for each iteration until you find the duplicate
                    if(set.contains(element)){
                        return element;
                    }
                    else{
                        set.add(element);
                    }


        Without using extra space:
            option 1 : O(N^2) by linearly searching each element one by one
            option 2: O(n log n) by sorting and using 2 pointers

            Consider each element as a index and if you detect the cycle then that means you're at duplicate number?

            1 -> 2 -> 3 -|
                 |_______|

            1 --> 3 --> 2

            1->2->3->4->|
                     |__|   

        */


        
        int slow = 0;
        int fast = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        int slow2 = 0;
        while (slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
        
    }
}
