package com.finalproject.lettersearch.strategy;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

public class DiagonalStrategy extends  SearchTemplate{

    @Override
    protected boolean matches(char[][] grid, String word, int row, int col) {
        if (row + word.length() > grid.length || col + word.length() > grid[0].length) {
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if(grid[row+k][col+k] != word.charAt(k)){
                return false;
            }
        }
        return true;
    }



}
