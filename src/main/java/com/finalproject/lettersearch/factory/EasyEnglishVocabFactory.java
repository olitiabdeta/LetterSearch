package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("englishVocabEasyFactory")
public class EasyEnglishVocabFactory extends VocabSearchFactory {

    @Override
    protected char[][] createGrid() {
        return new char[][]{
                {'A','N','A','L','O','G','Y','X'},
                {'C','O','N','T','E','X','T','Y'},
                {'P','H','R','A','S','E','Z','Q'},
                {'T','O','P','I','C','K','L','M'},
                {'A','U','T','H','O','R','N','O'},
                {'S','T','O','R','Y','X','X','X'},
                {'W','O','R','D','S','L','E','R'},
                {'R','E','A','D','I','N','G','S'},
        };
    }

    @Override
    protected List<Word> createWords() {
        return List.of(
                new Word("ANALOGY", false),
                new Word("CONTEXT", false),
                new Word("PHRASE", false),
                new Word("TOPIC", false),
                new Word("AUTHOR", false),
                new Word("STORY", false),
                new Word("WORDS", false),
                new Word("READING", false)
        );
    }
}
