package com.finalproject.lettersearch.strategy;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

public class VerticalStrategy implements WordSearchStrategy {

    @Override
    public boolean searchWord(Board board, Word word) {
        char[][] grid =  board.getBoard();
        String searchFor = word.getWord();
        int rows =  grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows - searchFor.length(); j++) {
                int k = 0;
                while (k < searchFor.length() && grid[j +k][i] == searchFor.charAt(k))
                 {
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
