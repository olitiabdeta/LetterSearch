package com.finalproject.lettersearch.observer;

import com.finalproject.lettersearch.data.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListObserver implements IObserver {
    private static final Logger logger = LoggerFactory.getLogger(ListObserver.class);

    @Override
    public void update(Word word) {
        logger.info("List updated, found word: {}", word.getWord());
        //will fill in once gamestatemanager is complete
    }
}
