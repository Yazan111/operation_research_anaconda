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

    private Square mLeftMagnitude;
    private Square mRightMagnitude;
    private Square mTopMagnitude;
    private Square mDownMagnitude;
    private Image mImage;
    private int mSquareId;
    private int mTokenId;


    private int mSquareSize;


    public static Square getBoardSquare(Image image, int squareId) {
        return new Square(image, squareId, sBoardSquareSize);
    }

    public static Square getTokenSquare(Image image) {
        return new Square(image, sTokenSquareSize);
    }

    private Square (Image image, int squareSize) {

        mSquareSize = squareSize;
        initializeAttriubtes(image, squareSize);
        mSquareId = sSquareId++;
    }

    // board squares
    private Square (Image image, int squareId, int squareSize) {

        mSquareSize = squareSize;
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

    public Square getLeftMagnitude() {
        return mLeftMagnitude;
    }

    public void setLeftMagnitude(Square leftMagnitude) {
        mLeftMagnitude = leftMagnitude;
    }

    public Square getRightMagnitude() {
        return mRightMagnitude;
    }

    public void setRightMagnitude(Square  rightMagnitude) {
        mRightMagnitude = rightMagnitude;
    }

    public Square  getTopMagnitude() {
        return mTopMagnitude;
    }

    public void setTopMagnitude(Square  topMagnitude) {
        mTopMagnitude = topMagnitude;
    }

    public Square  getDownMagnitude() {
        return mDownMagnitude;
    }

    public void setDownMagnitude(Square  downMagnitude) {
        mDownMagnitude = downMagnitude;
    }

    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        mImage = image;
        ((ImageView)this.getChildren().get(0)).setImage(mImage);
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

    public int getSquareSize() {
        return mSquareSize;
    }

    public Square getACopy() {
        return new Square(this.getImage(), this.getSquareId(), this.getSquareSize());
    }

}
