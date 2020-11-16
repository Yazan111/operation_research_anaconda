package managers;

import board.Board;
import board.Square;
import interfaces.MoveFactoryHelper;
import interfaces.ViewManagerHelper;
import javafx.scene.Node;
import move.MoveFactory;
import move.Request;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements MoveFactoryHelper, ViewManagerHelper {
    private ViewManager mViewManager;
    private MoveFactory mMoveFactory;
    private Board mBoard;
    private BoardManager mBoardManager;
    private Request mRequest;

    public GameManager() {

        // TODO: board size will be hard coded for now, but it
        //  can be impelemented as gui screen later
        mBoardManager = new BoardManager(5, 100);
        mBoard = mBoardManager.getBoard();

        mViewManager = new ViewManager(this);
        mMoveFactory = new MoveFactory(this);
    }

    public List<Node> getViewNodes() {
        return mViewManager.updateNodes();
    }

    @Override
    public Request getRequest() {
        return mRequest;
    }

    @Override
    public void requestMove(Request request) {
       // TODO: impelent this
    }

    @Override
    public Node getBoardNode() {
        return mBoard;
    }

    @Override
    public List<Node> getOutsideTokensNodes() {
        // TODO: implement this
        return null;
    }


    @Override
    public List<Node> getFreeCells() {
        List<Square> squares = mBoard.getFreeCells();
        List<Node> nodes = new ArrayList<>(squares);

        return nodes;
    }

    @Override
    public int getBoardWidth() {
        return mBoardManager.getBoardWidth();
    }
}
