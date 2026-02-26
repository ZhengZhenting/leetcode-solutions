class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9;i++){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<9;j++){
                if(board[i][j]!='.'){
                    if(!set.add(board[i][j])){
                    return false;
                     }
                }              
            }
        }

        for(int i=0; i<9;i++){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<9;j++){
                if(board[j][i]!='.'){
                    if(!set.add(board[j][i])){
                    return false;
                     }
                }   
            }
        }

        for(int row=0; row<3; row++){
            for(int col=0; col<3;col++){
                Set<Character> set = new HashSet<>();
                    for(int i=row*3;i<row*3+3;i++){
                        for(int j=col*3; j<col*3+3;j++){
                            if(board[i][j]!='.'){
                                if(!set.add(board[i][j])){
                                return false;
                                }
                            }
                        }
                    }
            }
        }

    return true;
    }
}