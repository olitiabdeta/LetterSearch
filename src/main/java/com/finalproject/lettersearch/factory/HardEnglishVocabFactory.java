package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("englishVocabHardFactory")
public class HardEnglishVocabFactory extends VocabSearchFactory {

    @Override
    protected char[][] createGrid() {
        return new char[][]{
                {'I','N','E','V','I','T','A','B','L','E','X','X','X'},
                {'I','N','T','R','I','C','A','T','E','X','X','X','X'},
                {'R','E','S','I','L','I','E','N','T','X','X','X','X'},
                {'S','O','P','H','I','S','T','I','C','A','T','E','D'},
                {'C','O','N','T','R','A','D','I','C','T','I','O','N'},
                {'C','O','N','S','E','Q','U','E','N','C','E','X','X'},
                {'X','X','X','X','X','X','X','X','X','X','X','X','X'},
                {'X','X','X','X','X','X','X','X','X','X','X','X','X'},
        };
    }

    @Override
    protected List<Word> createWords() {
        return List.of(
                new Word("INEVITABLE", false),
                new Word("INTRICATE", false),
                new Word("RESILIENT", false),
                new Word("SOPHISTICATED", false),
                new Word("CONTRADICTION", false),
                new Word("CONSEQUENCE", false)
        );
    }
}
