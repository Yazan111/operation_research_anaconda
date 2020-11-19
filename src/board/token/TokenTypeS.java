package board.token;

import board.Square;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class TokenTypeS extends TokenType{


    TokenTypeS() {
        initialize();
    }

    public List<Token> getTokens() {
        List<Token> tokens = new ArrayList<>();
        Token token_n = buildToken(mnImage, mnEdges);
        Token token_nr90 = buildToken(mnImage, mnr90Edges);

        rotateAndFlipToken("n", token_n.getShape());
        rotateAndFlipToken("nr90", token_nr90.getShape());

        tokens.add(token_n);
        tokens.add(token_nr90);
        return tokens;
    }

    // called in the constructor
    private void initialize() {
        mnImage.add(new Image("file:person-1-1.png"));
        mnImage.add(new Image("file:person-1-2.png"));
        mnImage.add(new Image("file:person-2-0.png"));
        mnImage.add(new Image("file:person-2-1.png"));

        // edges will be set for proper initialization of relations between square
        mnEdges.add("down");
        mnEdges.add("right");
        mnEdges.add("down");


/*
        mnr180Edges = mnEdges;
*/
        mnr90Edges.add("left");
        mnr90Edges.add("down");
        mnr90Edges.add("left");

/*
        mnr270Edges = mnr90Edges;

        mfnEdges.add("down");
        mfnEdges.add("left");
        mfnEdges.add("down");

        mfr180Edges = mfnEdges;

        mfr90Edges.add("right");
        mfr90Edges.add("down");
        mfr90Edges.add("right");

        mfr270Edges = mfr90Edges;
*/

/*
        mnr180Image.add(new Image("file:person-1-1.png"));
        mnr180Image.add(new Image("file:person-1-2.png"));
        mnr180Image.add(new Image("file:person-2-0.png"));
        mnr180Image.add(new Image("file:person-2-1.png"));

        mnr270Image.add(new Image("file:person-1-1.png"));
        mnr270Image.add(new Image("file:person-1-2.png"));
        mnr270Image.add(new Image("file:person-2-0.png"));
        mnr270Image.add(new Image("file:person-2-1.png"));

        mfImage.add(new Image("file:person-1-1.png"));
*/
    }

    private void rotateAndFlipToken(String position, List<Square> squares) {
        Square square1 = squares.get(0);
        Square square2 = squares.get(1);
        Square square3 = squares.get(2);
        Square square4 = squares.get(3);
        int size = Square.getTokenSquareSize();

        switch (position) {
            case "n":
                square1.setLayoutX(0);
                square1.setLayoutY(0);

                square2.setLayoutX(0);
                square2.setLayoutY(size);

                square3.setLayoutX(size);
                square3.setLayoutY(size);

                square4.setLayoutX(size);
                square4.setLayoutY(2 * size);
                break;

            case "nr90":
                square1.setLayoutX(2 * size);
                square1.setLayoutY(0);
                square1.getChildren().get(0).setRotate(90);

                square2.setLayoutX(size);
                square2.setLayoutY(0);
                square2.getChildren().get(0).setRotate(90);

                square3.setLayoutX(size);
                square3.setLayoutY(size);
                square3.getChildren().get(0).setRotate(90);

                square4.setLayoutX(0);
                square4.setLayoutY(size);
                square4.getChildren().get(0).setRotate(90);
                break;
        }
    }
}
