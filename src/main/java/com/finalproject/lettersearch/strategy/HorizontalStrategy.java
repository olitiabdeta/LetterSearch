package com.finalproject.lettersearch.strategy;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

public class HorizontalStrategy implements WordSearchStrategy{

    @Override
    public boolean searchWord(Board board, Word word) {
        char[][] grid =  board.getBoard();
        String searchFor = word.getWord();

        int rows =  grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - searchFor.length(); j++) {
                int k = 0;
                while (k < searchFor.length() &&  grid[i][j + k ] == searchFor.charAt(k)) {
                    k++;
                }
                if (k == searchFor.length()) {
                    return true;
                }
            }
        }
       return false;
    }
}
