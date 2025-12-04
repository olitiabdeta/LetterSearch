package com.finalproject.lettersearch.observer;

import com.finalproject.lettersearch.data.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScoreObserver implements IObserver {
    private static final Logger logger = LoggerFactory.getLogger(ScoreObserver.class);
    @Override
    public void update(Word word) {
        //will fill in once gamestatemanager is complete
        logger.info("Score updated, found word: {}", word.getWord());

    }
}
