class Solution {
    public boolean isPalindrome(String s) {
        String processed = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();;

        System.out.println(processed);

        int l = 0, r = processed.length() - 1;
        while(l < r){
            if(processed.charAt(l) == processed.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}
