package com.finalproject.lettersearch.strategy;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

public class VerticalStrategy extends SearchTemplate {


    @Override
    protected boolean matches(char[][] grid, String word, int row, int col) {
        if (row + word.length() > grid.length) {
            return false;
        }


        for (int k = 0; k < word.length(); k++) {
            if (grid[row + k][col] != word.charAt(k)) {
                return false;
            }

        }
       return true;
    }
}
