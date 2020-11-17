package board;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class Board extends Group {

    private Square[][] mBoardState;
    private int mGridSize;

    public Board(Square[][] boardState, int gridSize) {
        mBoardState = boardState;
        mGridSize = gridSize;

        List<Square> squares = new ArrayList<>();
        for(int i = 0; i < mGridSize; i ++)
            for(int j = 0; j < mGridSize; j ++) {
                squares.add(mBoardState[i][j]);
            }

        super.getChildren().addAll(squares);
    }

/*
    public Board putToken(Token token) {
        return searchBoardAndUpdateWithValue(token, token.getTokenId());
    }
    public Board removeToken(Token token) {

        return searchBoardAndUpdateWithValue(token, -1);
    }
*/

    public Square[][] getBoardState() {
        return mBoardState;
    }

    public int getGridSize() {
        return mGridSize;
    }

    public List<Square> getFreeCells() {
        Square square;
        List<Square> squares = new ArrayList<>();
        for(int i = 0; i < mGridSize; i ++) {
            for (int j = 0; j < mGridSize; j ++){
                square = mBoardState[i][j];
               if(square.getTokenId() == -1) {
                   squares.add(square);
               }
            }
        }
        return squares;
    }

    private Square getSquareById(int id) {
        for(int i = 0; i < mGridSize; i ++)
            for (int j = 0; j < mGridSize; j ++) {
                Square square = mBoardState[i][j];
                if (id == square.getSquareId())
                    return square;
            }

        return null;
    }

/*
    private Board searchBoardAndUpdateWithValue(Token token, int value) {

        List<Square> squares = token.getShape();
        for (Square square : squares) {
            Square boardSquare = getSquareById(square.getSquareId());
            if(boardSquare != null)
                boardSquare.setTokenId(value);
        }
        return new Board(mBoardState, mGridSize);
    }
*/
}
