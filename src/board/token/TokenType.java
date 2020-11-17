package board.token;

import board.Square;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public abstract class TokenType {
    protected List<Image> mnImage = new ArrayList<>();
    protected List<Image> mfImage = new ArrayList<>();

    //normal
    protected List<String> mnEdges = new ArrayList<>();
    protected List<String> mnr90Edges = new ArrayList<>();
    protected List<String> mnr180Edges = new ArrayList<>();
    protected List<String> mnr270Edges = new ArrayList<>();

    //flipped
    protected List<String> mfnEdges = new ArrayList<>();
    protected List<String> mfr90Edges = new ArrayList<>();
    protected List<String> mfr180Edges = new ArrayList<>();
    protected List<String> mfr270Edges = new ArrayList<>();

    public abstract List<Token> getTokens();

    protected Token buildToken(List<Image> images, List<String> edges) {
        List<Square> squares = new ArrayList<>();
        for (Image image : images) {
            squares.add(Square.getTokenSquare(image));
        }

        for(int i = 0; i < squares.size() - 1; i ++) {
            Square square1 = squares.get(i);
            Square square2 = squares.get(i + 1);
            String edge = edges.get(i);

            switch (edge) {
                case "down":
                    square1.setDownMagnitude(square2.getSquareId());
                    square2.setTopMagnitude(square1.getSquareId());
                    break;

                case "righ":
                    square1.setRightMagnitude(square2.getSquareId());
                    square2.setLeftMagnitude(square1.getSquareId());
                    break;

                case "left":
                    square1.setLeftMagnitude(square2.getSquareId());
                    square2.setRightMagnitude(square1.getSquareId());
                    break;

                case "top":
                    square1.setTopMagnitude(square2.getSquareId());
                    square2.setDownMagnitude(square1.getSquareId());
                    break;
            }
        }

        return new Token(squares);
    }
}
