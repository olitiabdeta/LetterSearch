package com.finalproject.lettersearch.strategy;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import org.springframework.boot.autoconfigure.web.WebProperties;

public class HorizontalStrategy extends SearchTemplate {

    @Override
    protected boolean matches(char[][] grid, String word, int row, int col) {
        if (col + word.length() > grid[0].length) {
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if (grid[row][col +k] != word.charAt(k)) {
                return false;
            }

        }
        return true;
    }
}
