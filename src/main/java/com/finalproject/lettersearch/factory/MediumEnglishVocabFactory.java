package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("englishVocabMediumFactory")
public class MediumEnglishVocabFactory extends VocabSearchFactory {

    @Override
    protected char[][] createGrid() {
        return new char[][]{
                {'E','L','O','Q','U','E','N','T'},
                {'P','E','R','S','P','I','C','A'},
                {'C','I','O','U','S','X','X','X'},
                {'L','U','M','I','N','O','U','S'},
                {'M','E','T','I','C','U','L','O'},
                {'U','S','X','X','X','X','X','X'},
                {'A','M','B','I','G','U','O','U'},
                {'S','X','X','X','X','X','X','X'},
        };
    }

    @Override
    protected List<Word> createWords() {
        return List.of(
                new Word("ELOQUENT", false),
                new Word("PERSPICACIOUS", false),
                new Word("CONSCIOUS", false),
                new Word("LUMINOUS", false),
                new Word("METICULOUS", false),
                new Word("AMBIGUOUS", false)
        );
    }
}