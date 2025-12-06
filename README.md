

# LetterSearch

**Project Team Members:** Oliti Abdeta and Vaishnavi Tekavade

---

## Description
LetterSearch is an interactive word-search puzzle game developed using Java,
Springboot, and HTML. The game presents players with a grid of letters containing a set of
hidden words related to a selected theme. The goal is to locate all the hidden words by identifying
them within the grid horizontally, vertically, or diagonally. Players will interact with the puzzle by
inputting their guesses in a search box. If the selected letters match one of the hidden words, the word
will be marked as found, and the letters will be highlighted in the grid. The game will track the number
of words found, provide feedback, and display the user’s score. LetterSearch combines puzzle-solving,
pattern recognition, and vocabulary practice into an engaging digital experience.

---

## Five Patterns Used
- **Factory Pattern:** Used for creating game boards with different themes.
- **Strategy Pattern:** Implements different search strategies (Horizontal, Vertical, Diagonal) for word matching.
- **Observer Pattern:** Updates score and word list dynamically as words are found.
- **Template Pattern:** Provides shared search logic for word search strategies.
- **Singleton Pattern:** `GameStateManager` ensures a single source of truth for game state.

---


