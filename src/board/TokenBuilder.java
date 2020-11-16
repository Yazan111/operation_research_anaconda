package board;

import java.util.ArrayList;
import java.util.List;

public class TokenBuilder {
    private List<Token> mTokens;

    public TokenBuilder() {
        mTokens = new ArrayList<>();
        initializeTokens();
    }

    public Token getTokenById(int id) {
        for (Token token : mTokens) {
            if (token.getTokenId() == id) {
                return token;
            }
        }
        return null;
    }

    public List<Token> getTokens() {
        return mTokens;
    }

    private void initializeTokens() {
        Token lToken = buildTokenOfTypeL();
        // build other tokens


        mTokens.add(lToken);
    }

    private Token buildTokenOfTypeL() {
        Square square1 = new Square(null, -1);
        Square square2 = new Square(null, -1);
        Square square3 = new Square(null, -1);
        Square square4 = new Square(null, -1);
        square1.setDownMagnitude(square2.getSquareId());

        square2.setTopMagnitude(square1.getSquareId());
        square2.setLeftMagnitude(square3.getSquareId());

        square3.setRightMagnitude(square2.getSquareId());
        square3.setDownMagnitude(square4.getSquareId());

        square4.setTopMagnitude(square3.getSquareId());

        List<Square> squares = new ArrayList<>();
        squares.add(square1);
        squares.add(square2);
        squares.add(square3);
        squares.add(square4);

        return new Token(squares);
    }
}
