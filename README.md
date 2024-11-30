# Chess Project in Java

## Project Description
This project is a chess game implemented in Java using advanced data structures and object-oriented programming (OOP) principles.  
The game operates on a 2D board and follows the official chess rules, including the ability to capture opponent pieces.  

Currently, the game supports playing against the computer. The AI player uses a simple algorithm that makes random legal moves. In future updates, the AI will be enhanced with advanced algorithms such as Minimax with Alpha-Beta Pruning to provide a more challenging and strategic gameplay experience.  

Additionally, a graphical user interface (GUI) is under development and will be added in future versions, offering players a more interactive and visually engaging experience.

## Project Structure
- **`Board` Class**  
  Represents the chessboard as a 2D array, updating the positions of the pieces after each move.  
  
- **`Piece` Class (Base Class)**  
  Represents a generic chess piece. Includes methods such as `isValidMove`.

- **Specific Piece Classes**  
  For example: **Pawn, Knight, Bishop**, etc., each implementing the unique movement rules of the piece.

- **`ChessGame` Class**  
  Manages the game logic, tracks player turns, checks for special conditions like check and checkmate, and executes moves. The class includes a timer to track whether moves are being made within the allocated time for each player.

- **`ChessTimer` Class**  
  Manages the time for each player, including counting down time per move and game duration, and displays the clock in real-time during the game.

- **AI Player**  
  A basic AI has been implemented that allows players to compete against the computer. Currently, the AI selects random moves, but advanced algorithms, such as Minimax, will be integrated in future versions.

## Current Features
- Support for legal moves of all chess pieces.
- Detection of check and checkmate situations.
- Capture of opponent pieces.
- Playable against a computer using a random-move AI.
- Move timing management using a timer.

## Upcoming Features
1. **Graphical User Interface (GUI)**:  
   A graphical representation of the chessboard is under development and will be included in future versions. The GUI will allow players to interact with the game visually and intuitively.  

2. **Advanced AI**:  
   - Integration of Minimax with Alpha-Beta Pruning to improve the AI's gameplay strategy.  
   - Enhanced AI decision-making for a more challenging experience.  

3. **Additional Gameplay Features**:  
   - Support for promotion and castling.  
   - "Undo" functionality.  
   - Online multiplayer mode.  

## Ideas for Future Development
1. **Theme Customization**:  
   - Allow players to customize the board and pieces' design.  

2. **Game Saving**:  
   - Save and load games to continue play later.  

3. **Tutorial Mode**:  
   - Include an interactive tutorial for new players to learn the rules of chess.  

## Installation and Running Instructions
1. Ensure that a compatible JDK is installed on your system (Java 8 or later is recommended).
2. Import the project files into your preferred IDE (e.g., IntelliJ or Eclipse).
3. Run the main file (`Main.java` or a similar file) to start the game.

## Notes
This project is open to further enhancements and improvements. Contributions, new ideas, or advanced algorithms are welcome.

## Author
This project was developed by Daniel Samuelov.  
I look forward to continuing work on it and exploring new ideas, including the upcoming graphical interface, improved time management, and advanced AI algorithms.
