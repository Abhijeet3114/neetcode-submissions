class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> braceMap = new HashMap<>();

        /*
        [][]
        [
        ]

        when there is opening bracket, then push it's closing bracket to the stack
        when there's closing bracker, then it should match with top of stack

        i/p: [ then stack = ]
        i/p: ] then stack = Empty

        return stack.isEmpty()
        

        */




        braceMap.put('(', ')');
        braceMap.put('{', '}');
        braceMap.put('[', ']');

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(braceMap.containsKey(c)){
                stack.push(braceMap.get(c));
            }
            else{
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
