package board;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.Random;

public class Square extends StackPane{
    private int mLeftMagnitude;
    private int mRightMagnitude;
    private int mTopMagnitude;
    private int mDownMagnitude;
    private Image mImage;
    private int mSquareId;
    private int mTokenId;
    private int mSquareSize;

    public Square(Image image, int tokenId) {
        mSquareSize = 100;
        Random random = new Random();
        // this will generate a number between 1 and 100
        mSquareId = random.nextInt(100) + 1;
        mImage = image;
        mTokenId = tokenId;

        ImageView imageView = new ImageView();
        imageView.setImage(image);
        super.getChildren().add(imageView);

        // related to layout
        super.setMinWidth(mSquareSize);
        super.setMinHeight(mSquareSize);
        super.setBackground(new Background(
                new BackgroundFill(
                        Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY
                    )
                )
            );
    }

    public int getLeftMagnitude() {
        return mLeftMagnitude;
    }

    public void setLeftMagnitude(int leftMagnitude) {
        mLeftMagnitude = leftMagnitude;
    }

    public int getRightMagnitude() {
        return mRightMagnitude;
    }

    public void setRightMagnitude(int rightMagnitude) {
        mRightMagnitude = rightMagnitude;
    }

    public int getTopMagnitude() {
        return mTopMagnitude;
    }

    public void setTopMagnitude(int topMagnitude) {
        mTopMagnitude = topMagnitude;
    }

    public int getDownMagnitude() {
        return mDownMagnitude;
    }

    public void setDownMagnitude(int downMagnitude) {
        mDownMagnitude = downMagnitude;
    }

    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        mImage = image;
    }

    public int getSquareId() {
        return mSquareId;
    }

    public void setSquareId(int squareId) {
        mSquareId = squareId;
    }

    public int getTokenId() {
        return mTokenId;
    }

    public void setTokenId(int tokenId) {
        mTokenId = tokenId;
    }
}
