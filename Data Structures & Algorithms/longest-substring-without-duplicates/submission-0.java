class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            one option is generate all substrings and use hashmap to store the frequency

            option 2: start from the first char
                expand to the left and right until the condition holds
                    while((!hashSet.contains(r))
                        add r to string
                    
                    check the length of string
        */


        // corner case, string is empty or only single char present
        if(s.length() < 1){
            return s.length();
        }


        int l = 0, r = 1;
        HashSet<Character> chars = new HashSet<>();
        chars.add(s.charAt(l));
        int maxLen = 1;

        while(r < s.length()){
            while(chars.contains(s.charAt(r))){
                chars.remove(s.charAt(l));
                l++;
            }
            
            chars.add(s.charAt(r));
            maxLen = Math.max(1+r-l, maxLen);
            r++;
        }

        return maxLen;

    }
}
