package board;

import javafx.scene.input.TransferMode;
import move.Validator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traverser {
    BoardGenerator mBoardGenerator;
    Validator mValidator;

    Traverser(BoardGenerator boardGenerator) {
        this.mBoardGenerator = boardGenerator;
    }

    public boolean DFS(Board board) {

        Stack stack = new Stack();
        stack.add(board);
        while(!stack.isEmpty()) {
            Board board1 = (Board) stack.pop();
            if(mValidator.validate(board)) return true;

            List<Board> generatedBoards = mBoardGenerator.getGeneratedBoards();
            stack.addAll(generatedBoards);

        }
        return false;
    }

    public boolean BFS(Board board) {
        Queue queue = new LinkedList();
        queue.add(board);
        while(!queue.isEmpty()) {
            Board board1 = (Board) queue.poll();
            if(mValidator.validate(board)) return true;

            List<Board> generatedBoards = mBoardGenerator.getGeneratedBoards();
            queue.addAll(generatedBoards);

        }
        return false;
    }
}
