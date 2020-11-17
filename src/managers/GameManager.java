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
    private final ViewManager mViewManager;
    private MoveFactory mMoveFactory;
    private final BoardManager mBoardManager;
    private Request mRequest;

    public GameManager() {

        // TODO: board size will be hard coded for now, but it
        //  can be impelemented as gui screen later
        mBoardManager = new BoardManager(5);

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
        return mBoardManager.getBoard();
    }

    @Override
    public List<Node> getOutsideTokensNodes() {
        return new ArrayList<>(mBoardManager.getOutsideTokens());
    }


    @Override
    public List<Node> getFreeCells() {
        return new ArrayList<>(mBoardManager.getFreeCells());
    }

    @Override
    public int getBoardWidth() {
        return mBoardManager.getBoardWidth();
    }
}
