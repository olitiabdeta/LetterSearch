package com.finalproject.lettersearch.strategy;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

public interface WordSearchStrategy {
    boolean searchWord(Board board, Word word);
}
