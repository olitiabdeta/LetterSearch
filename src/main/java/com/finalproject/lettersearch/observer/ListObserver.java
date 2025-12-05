package com.finalproject.lettersearch.observer;

import com.finalproject.lettersearch.data.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ListObserver implements IObserver {
    private static final Logger logger = LoggerFactory.getLogger(ListObserver.class);
    private final List<String> foundWords = new ArrayList<>();
    @Override
    public void update(Word word) {
        if (!foundWords.contains(word.getWord())) {
            foundWords.add(word.getWord());
        }
        logger.info("List updated, found words: {}", foundWords);
        //will fill in once gamestatemanager is complete
    }
    public List<String> getFoundWords() {
        return foundWords;
    }
}
