package board;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class Square extends StackPane{
    private static final int sTokenSquareSize = 50;
    private static final int sBoardSquareSize = 100;
    private static int sSquareId = 1000;

    private int mLeftMagnitude;
    private int mRightMagnitude;
    private int mTopMagnitude;
    private int mDownMagnitude;
    private Image mImage;
    private int mSquareId;
    private int mTokenId;


    public static Square getBoardSquare(Image image, int squareId) {
        return new Square(image, squareId, sBoardSquareSize);
    }

    public static Square getTokenSquare(Image image) {
        return new Square(image, sTokenSquareSize);
    }

    private Square (Image image, int squareSize) {

        initializeAttriubtes(image, squareSize);
        mSquareId = sSquareId++;

    }

    // board squares
    private Square (Image image, int squareId, int squareSize) {

        initializeAttriubtes(image, squareSize);
        mSquareId = squareId;
    }

    private void initializeAttriubtes(Image image, int squareSize) {
        mImage = image;

        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(squareSize);
        imageView.setFitWidth(squareSize);
        super.getChildren().add(imageView);

        // related to layout
        super.setStyle("-fx-border-color: black;");
        super.setMinWidth(squareSize);
        super.setMinHeight(squareSize);
        super.setBackground(new Background(
                        new BackgroundFill(
                                Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY
                        )
                )
        );
    }

    public static int getBoardSquareSize(){
        return sBoardSquareSize;
    }

    public static int getTokenSquareSize(){
        return sTokenSquareSize;
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
