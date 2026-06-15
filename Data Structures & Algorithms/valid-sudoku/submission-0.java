class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<String, HashSet<Character>> square = new HashMap<>();


        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                /*
                    when i denotes row no
                        then j denotes col no
                        how to get the square key
                            : i/3 +","+j/3

                        first square : 00
                            00 01 02
                            10 11 12
                            20 21 22

                        Second sqaure : 01
                            03 04 05
                            13 14 15
                            23 24 25
                        
                        Third sqaure : 02
                            06 07 08
                            16 17 18
                            26 27 28

                        Fourth sqaure : 10
                            30 31 32
                            40 41 42
                            50 51 52
                        
                        Fifth Square : 11
                            33 

                        Sixth Sq = 12
                */


                if(board[r][c] == '.'){
                    continue;
                }

                String key = r/3 +","+c/3;
                if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    square.computeIfAbsent(key, k -> new HashSet<>()).contains(board[r][c])
                ){
                    return false;
                }
                else{
                    rows.get(r).add(board[r][c]);
                    cols.get(c).add(board[r][c]);
                    square.get(key).add(board[r][c]);
                }
            }
        }

        return true;
    }
}
