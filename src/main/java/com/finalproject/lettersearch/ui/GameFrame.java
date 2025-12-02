package ui;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import com.finalproject.lettersearch.factory.VocabSearchFactory;
import com.finalproject.lettersearch.service.Game;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameFrame extends JFrame {

    private final Game game;
    private final Board board;
    private final List<Word> words;

    public GameFrame() {

        // 1. Create the factory for English Vocab theme
        VocabSearchFactory factory = new VocabSearchFactory();

        // 2. Create and start the game
        this.game = new Game(factory);
        this.game.startGame();

        // 3. Load board + words
        this.board = game.getBoard();
        this.words = board.getWords();

        // 4. Window setup
        setTitle("LetterSearch - English Vocab Theme");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 5. Add the board panel (draws grid + letters)
        BoardPanel boardPanel = new BoardPanel(board, words);
        add(boardPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);  // center on screen
        setVisible(true);
    }

    public Game getGame() {
        return game;
    }
}
