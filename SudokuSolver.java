package baid.ankit;

public class SudokuSolver {
    private static final int SIZE = 9;
    public static void main(String[] args) {
        int[][] sudoku = 
        {
           {0,1,3,8,0,0,4,0,5},
           {0,2,4,6,0,5,0,0,0},
           {0,8,7,0,0,0,9,3,0},
           {4,9,0,3,0,6,0,0,0},
           {0,0,1,0,0,0,5,0,0},
           {0,0,0,7,0,1,0,9,3},
           {0,6,9,0,0,0,7,4,0},
           {0,0,0,2,0,7,6,8,0},
           {1,0,2,0,0,8,3,5,0}
        };

        if(solveBoard(sudoku)){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }
    }

    private static boolean solveBoard(int[][] board){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(board[i][j] == 0){
                    for (int index = 1; index <= SIZE; index++) {
                        if(isValid(board, index, i, j)){
                            board[i][j] = index;

                            if(solveBoard(board)){
                                return true;
                            }else{
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                } 
            }
        }
        return true;
    }

    private static boolean checkInRow(int[][] board, int number, int row){
        for(int i = 0; i < SIZE; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;   
    }
    private static boolean checkInColumn(int[][] board, int number, int column){
        for(int i = 0; i < SIZE; i++){
            if(board[i][column] == number){
                return true;
            }
        }
        return false;   
    }

    private static boolean checkInBox(int[][] board, int number, int row, int column){
        int boxRowIndex = row - row % 3;
        int boxColumnIndex = column - column % 3;
        for (int i = boxRowIndex; i < boxRowIndex + 3 ; i++) {
            for (int j = boxColumnIndex; j < boxColumnIndex + 3; j++) {
                if(board[i][j] == number){
                    return true;
                }
            }
            
        }
        return false;
    }

    private static boolean isValid(int[][] board, int number, int row, int column){
        return !checkInBox(board, number, row, column) 
            && !checkInRow(board, number, row) 
            && !checkInColumn(board, number, column);
    }
}
