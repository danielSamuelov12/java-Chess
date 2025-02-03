# Chess Project in Java

## Project Description
This project is a chess game implemented in Java using advanced data structures and object-oriented programming (OOP) principles.  
The game operates on a 2D board and follows the official chess rules, including the ability to capture opponent pieces.

Currently, the game supports playing against the computer. The AI player initially used a simple algorithm that makes random legal moves. In recent updates, the AI has been enhanced with advanced algorithms such as **Minimax** (with plans for further improvements via Alpha-Beta Pruning) to provide a more challenging and strategic gameplay experience.

Additionally, a graphical user interface (GUI) is under development and will be added in future versions, offering players a more interactive and visually engaging experience.

## Project Structure
- **`Board` Class**  
  Represents the chessboard as a 2D array, updating the positions of the pieces after each move. It now also supports cloning (for AI search) and maintains the game state for undo functionality.
  
- **`Piece` Class (Base Class)**  
  Represents a generic chess piece. Includes methods such as `isValidMove`. Each specific piece implements its own `clone()` method to support state copying for the AI.
  
- **Specific Piece Classes**  
  For example: **Pawn, Knight, Bishop, Rook, Queen, King** – each implementing the unique movement rules of the piece along with cloning functionality.
  
- **`ChessGame` Class**  
  Manages the game logic, tracks player turns, checks for special conditions like check and checkmate, executes moves, and handles undo functionality. It also integrates a timer (via the `ChessTimer` class) to track move durations.
  
- **`ChessTimer` Class**  
  Manages the time for each player, including counting down time per move and overall game duration, and displays the clock in real-time during the game.
  
- **AI Player**  
  The AI player now uses the **Minimax algorithm** (with a basic implementation) to evaluate moves and choose the most optimal move rather than selecting moves at random. Future versions will enhance this further with Alpha-Beta Pruning and deeper search depths.
  
- **`HumanPlayer` Class**  
  Provides functionality for human players to input moves via the console (or later via a GUI).

## Current Features
- Support for legal moves of all chess pieces.
- Detection of check and checkmate situations.
- Capture of opponent pieces.
- Playable against a computer using an AI based on the **Minimax algorithm**.
- "Undo" functionality – players can revert to a previous game state.
- Move timing management using a timer.

## Upcoming Features
1. **Graphical User Interface (GUI):**  
   A graphical representation of the chessboard is under development and will be included in future versions. The GUI will allow players to interact with the game visually and intuitively.

2. **Advanced AI Enhancements:**  
   - Further integration of Minimax with **Alpha-Beta Pruning** for improved performance and deeper search capabilities.
   - Enhanced AI decision-making for a more challenging experience.

3. **Additional Gameplay Features:**  
   - Support for pawn promotion and castling.
   - Online multiplayer mode.
   - Game saving/loading functionality.
   - Tutorial mode for new players.

## Ideas for Future Development
1. **Theme Customization:**  
   - Allow players to customize the board and pieces' design.
  
2. **Game Saving:**  
   - Save and load games to continue play later.
  
3. **Tutorial Mode:**  
   - Include an interactive tutorial for new players to learn the rules of chess.

## Installation and Running Instructions
1. Ensure that a compatible JDK is installed on your system (Java 8 or later is recommended).
2. Import the project files into your preferred IDE (e.g., IntelliJ IDEA or Eclipse).
3. Run the main file (e.g., `Main.java`) to start the game.

## New Functions and Enhancements
- **Minimax AI:**  
  The AI now uses the Minimax algorithm to recursively evaluate board states and select the optimal move. This algorithm simulates possible moves for both players, evaluating board positions using a simple evaluation function.  
  - **How it Works:**  
    - The algorithm builds a game tree from the current state to a certain depth.
    - At each node, it alternates between "maximizing" (AI's turn) and "minimizing" (opponent's turn).
    - Terminal nodes (or nodes at the search depth) are evaluated using an evaluation function that assigns scores based on material value and board state.
    - The best move is chosen by propagating these scores back up the tree.
  
- **Undo Functionality:**  
  The game now supports an "undo" feature that allows reverting to previous game states. The `Board` class supports cloning, and the `ChessGame` class maintains a history stack to enable this functionality.

## Author
This project was developed by Daniel Samuelov.  
Contributions, new ideas, or advanced algorithms are welcome as the project continues to evolve with a focus on enhanced AI, improved gameplay features, and an upcoming graphical interface.
