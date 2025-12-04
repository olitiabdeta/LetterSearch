package com.finalproject.lettersearch.strategy;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

public abstract class SearchTemplate {
    public final boolean search(Board board, Word word) {
        char[][] grid =  board.getBoard();
        String searchFor = word.getWord();

        int rows =  grid.length;
        int cols = grid[0].length;
        int wordLength = searchFor.length();
        for (int i = 0; i < rows;  i++) {
            for (int j = 0; j < cols; j++) {
                if(matches(grid, searchFor, i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected abstract boolean matches(char [][] grid, String word, int row, int col);
}
