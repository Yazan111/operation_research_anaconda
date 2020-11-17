package managers;

import interfaces.ViewManagerHelper;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import move.Request;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {

    private final ViewManagerHelper mViewManagerHelper;
    private Request mRequest;

    private final int mBoardShift;
    private int mTokensShift;

    // note that the player class is a model class and will
    // not be implemented unless for adding improvements on game
    private Player mPlayer;

    ViewManager(ViewManagerHelper helper) {

        this.mViewManagerHelper = helper;


        this.mBoardShift = 50;
        this.mTokensShift = getTokensShift();
        this.mTokensShift += 50;

    }

    private int getTokensShift() {
        int boardWidth = mViewManagerHelper.getBoardWidth();
        boardWidth += mBoardShift;

        return boardWidth;
    }

    public List<Node> updateNodes() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(buildBoardNode());

        if(buildTokensNodes() != null)
            nodes.add(buildTokensNodes());

        return nodes;
    }

    public void acceptInput() {

    }
    public Node buildBoardNode() {
        Node board = mViewManagerHelper.getBoardNode();
        board.setLayoutX(mBoardShift);
        board.setLayoutY(mBoardShift);

        return board;
    }

    public Node buildTokensNodes() {
        List<Node> tokens = mViewManagerHelper.getOutsideTokensNodes();

        VBox box = new VBox();
        box.getChildren().addAll(tokens);
        box.setLayoutX(mTokensShift);
        box.setLayoutY(mBoardShift);

        return box;
    }
}
