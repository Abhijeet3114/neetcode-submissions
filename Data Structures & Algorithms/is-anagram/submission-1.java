class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] aux = new int[26];
        for(int i = 0; i < s.length(); i++){
            aux[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            aux[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(aux[i] != 0){
                return false;
            }
        }

        return true;
    }
}
