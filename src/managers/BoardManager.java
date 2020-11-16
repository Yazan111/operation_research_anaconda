package managers;

import board.*;

import java.util.List;

public class BoardManager {
    private Board mBoard;
    private final List<Token> mTokens;
    private final TokenBuilder mTokenBuilder;
    private int mBoardCellShift;
    private BoardHistory mBoardHistory;

    BoardManager(int boardSize, int boardCellShift) {
        mTokenBuilder = new TokenBuilder();
        mTokens = mTokenBuilder.getTokens();
        mBoardCellShift = boardCellShift;
        initializeBoard(boardSize);
    }
    private void initializeState() {
        // TODO: implement an initial state
    }

    private void initializeBoard(int boardSize) {

        Square[][] board = new Square[boardSize][boardSize];


        for (int i = 0; i < boardSize; i ++)
            for (int j = 0; j < boardSize; j++) {
                String stringTokenId =  i + "" + j;
                int intTokenId = Integer.valueOf(stringTokenId);

                Square square = new Square(null, intTokenId);

                square.setLayoutX(i * mBoardCellShift);
                square.setLayoutY(j * mBoardCellShift);
                square.setStyle("-fx-border-color: black;");

                board[i][j] = square;
            }
        mBoard = new Board(board, boardSize);
    }
    public int getBoardWidth() {
       return mBoardCellShift * mBoard.getGridSize();
    }

    public Board getBoard() {
        return mBoard;
    }
}
