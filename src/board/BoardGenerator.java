package board;

import managers.GameManager;
import move.Request;

import java.util.ArrayList;
import java.util.List;

public class BoardGenerator {

    private List<Board> mGeneratedBoards;
    private List<Square> mSquares;
    private GameManager mGameManager;

    BoardGenerator(List<Square> squares) {
        mGeneratedBoards = new ArrayList<>();
        this.mSquares = squares;
    }

    public List<Board> getGeneratedBoards() {
        return mGeneratedBoards;
    }

    // generate boards will be called in order to create the mBoards varibale
    // then getBoards will be called by
    // game manager after filling it <by game manager itself>

    public void generateBoards(Board board) {
        Request request = new Request();
        List<Square> squares = board.getFreeCells();

        for(Square square : mSquares) {
            request.setRequestName("changeLocation");
            request.setSquareId(Integer.toString(square.getSquareId()));
            for(Square boardCell : squares) {
                request.setLocation(Integer.toString(boardCell.getSquareId()));
                mGameManager.requestMove(request);
            }
        }
    }

    public void addBoard(Board board) {
        mGeneratedBoards.add(board);
    }

}
