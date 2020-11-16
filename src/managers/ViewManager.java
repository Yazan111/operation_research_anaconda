package managers;

import interfaces.ViewManagerHelper;
import javafx.scene.Node;
import move.Request;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {

    private ViewManagerHelper mViewManagerHelper;
    private Request mRequest;

    private int mBoardShift;
    private int mTokensShift;

    // note that the player class is a model class and will
    // not be implemented unless for adding improvements on game
    private Player mPlayer;

    ViewManager(ViewManagerHelper helper) {

        this.mViewManagerHelper = helper;
        this.mBoardShift = 100;
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

        // TODO: impelemnt for prober drawing
        if(buildTokensNodes() != null)
            nodes.addAll(buildTokensNodes());

        return nodes;
    }

    public void acceptInput() {

    }
    public Node buildBoardNode() {
        Node board = mViewManagerHelper.getBoardNode();
        board.setLayoutX(100);
        board.setLayoutY(100);

        return board;
    }

    public List<Node> buildTokensNodes() {
        List<Node> tokens = mViewManagerHelper.getOutsideTokensNodes();
        int nodeCounter = 0;
        int secondTokenShift = 250;

        return null;
    }




}
