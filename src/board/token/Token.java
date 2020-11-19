package board.token;

import board.Square;
import javafx.scene.Group;

import java.util.List;
import java.util.Random;

public class Token extends Group {
    private static int sTokenId = 0;

    private List<Square> mShape;
    private boolean mMovable;
    private int mTokenId;

    public Token(List<Square> shape) {

        mShape = shape;
        mTokenId = sTokenId++;

        for(int i = 0; i < mShape.size(); i ++) {
           mShape.get(i).setTokenId(mTokenId);
        }
        getChildren().addAll(shape);
    }

    public void rotate() {
    }


    public List<Square> getShape() {
        return mShape;
    }

    public void setShape(List<Square> shape) {
        mShape = shape;
    }

    public boolean isMovable() {
        return mMovable;
    }

    public void setMovable(boolean movable) {
        mMovable = movable;
    }

    public int getTokenId() {
        return mTokenId;
    }

}
