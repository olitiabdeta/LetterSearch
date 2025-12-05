package com.finalproject.lettersearch.observer;

import com.finalproject.lettersearch.data.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScoreObserver implements IObserver {
    private static final Logger logger = LoggerFactory.getLogger(ScoreObserver.class);
    private int score = 0;
    private static final int WORD_POINTS = 5;
    @Override
    public void update(Word word) {
        if (word.isFound()) {
            score+=WORD_POINTS;
            logger.info("Score updated, found word: {}, score: {}", word.getWord(),  score);
        }
        //will fill in once gamestatemanager is complete

    }
    public int getScore() {
        return score;
    }
}
