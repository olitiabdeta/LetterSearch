package com.finalproject.lettersearch.strategy;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

public class DiagonalStrategy implements  WordSearchStrategy{

    @Override
    public boolean searchWord(Board board, Word word) {
        char[][] grid =  board.getBoard();
        String searchFor = word.getWord();
        int rows =  grid.length;
        int cols = grid[0].length;
        int wordLength = searchFor.length();
        for (int i = 0; i < rows - wordLength; i++) {
            for (int j = 0; j < cols - wordLength ; j++) {
                int k = 0;
                while (k < wordLength && grid[i +k][j +k] ==  searchFor.charAt(k)) {
                    k++;
                }
                if (k == wordLength) {
                    return true;
                }
            }
        }
        return false;
    }
}
