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
    private BoardHistory mBoardHistory;
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

                square.setLayoutX(i * size);
                square.setLayoutY(j * size);

                board[i][j] = square;
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
    public Token getTokenBySquareId(int id) {
        List<Square> tokenSquares;
        for(Token token : mTokens) {
            tokenSquares = token.getShape();
            for(Square square : tokenSquares) {
                if(square.getTokenId() == id)
                    return token;
            }
        }
        return null;
    }


    public Board getBoard() {
        return mBoard;
    }

}
