package managers;

import board.*;
import board.token.Token;
import board.token.TokenBuilder;

import java.util.ArrayList;
import java.util.List;

public class BoardManager {
    private Board mBoard;
    private final List<Token> mTokens;
    private final TokenBuilder mTokenBuilder;
    private BoardGenerator mBoardGenerator;
    private final List<Token> mOutsideTokens;

    BoardManager(int boardSize) {
        mTokenBuilder = new TokenBuilder();
        mTokens = mTokenBuilder.getTokens();
        mOutsideTokens = mTokenBuilder.getTokens();
        initializeBoard(boardSize);
    }
    private void initializeState() {
        // TODO: implement an initial state
    }

    public List<Token> getOutsideTokens() {
        return mOutsideTokens;
    }
    public List<Square> getFreeCells() {
        return mBoard.getFreeCells();
    }

    private void initializeBoard(int boardSize) {

        Square[][] board = new Square[boardSize][boardSize];


        int size = Square.getBoardSquareSize();
        for (int i = 0; i < boardSize; i ++)
            for (int j = 0; j < boardSize; j++) {
                String stringTokenId =  i + "" + j;
                int intSquareId = Integer.parseInt(stringTokenId);

                Square square = Square.getBoardSquare(null, intSquareId);

                square.setLayoutX(j * size);
                square.setLayoutY(i * size);



                board[i][j] = square;
            }
        for (int i = 0; i < boardSize; i ++)
            for (int j = 0; j < boardSize; j++) {

                board[i][j].setTokenId(-1);
                int upRow = i - 1;
                int downRow = i + 1;
                int leftColumn = j - 1;
                int rightColumn = j + 1;
                if (upRow >= 0)
                    board[i][j].setTopMagnitude(board[upRow][j]);

                if (downRow < boardSize)
                    board[i][j].setDownMagnitude(board[downRow][j]);

                if (leftColumn >= 0)
                    board[i][j].setLeftMagnitude(board[i][leftColumn]);

                if (rightColumn < boardSize)
                    board[i][j].setRightMagnitude(board[i][rightColumn]);
            }

        mBoard = new Board(board, boardSize);
    }
    public int getBoardWidth() {
        return Square.getBoardSquareSize() * mBoard.getGridSize();
    }

    public List<Square> getOutsideTokensSquare() {
        List<Square> tokenSquare = new ArrayList<>();
        for(Token token : mTokens)  {
            tokenSquare.addAll(token.getShape());
        }

        return tokenSquare;
    }

    public Square findSquareById(int id) {
        List<Square> allSquares = new ArrayList<>();
        for(Token token : mTokens) {
            List<Square> tokenSquares = token.getShape();
            allSquares.addAll(tokenSquares);
        }
        for(int i = 0; i < mBoard.getGridSize(); i ++)
            for(int j = 0; j < mBoard.getGridSize(); j ++)
                allSquares.add(mBoard.getBoardState()[i][j]);

        for(Square square : allSquares) {
            if(square.getSquareId() == id)
                return square;
        }

        return null;
    }


    public Board getBoard() {
        return mBoard;
    }

}
