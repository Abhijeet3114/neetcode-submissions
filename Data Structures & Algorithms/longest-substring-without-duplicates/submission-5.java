class Solution {
    public int lengthOfLongestSubstring(String s) {

        /*
        brute force:
            for each substring
                0 to i (1 to 9)
                    check if each character is appearing only once

        Otherwise use hashset
            keep inserting elements into hashset if you find the duplicate 
                then
                    update maxLength so far with the current length if greater
                    clear hashset
                    clear current length
                    update start of substring to current pos
        */

        if(s.length() <= 1){
            return s.length();
        }

        Set<Character> distinct = new HashSet<>();
        distinct.add(s.charAt(0));
        int l = 0;
        int result = 1;
        for(int r = 1; r < s.length(); r++){
            result = Math.max(result, distinct.size());
            while(distinct.contains(s.charAt(r))){
                distinct.remove(s.charAt(l));
                l++;
            }
            distinct.add(s.charAt(r));
        }
        result = Math.max(result, distinct.size());

        return result;
        
    }
}
