package managers;

import board.Board;
import board.Square;
import board.token.Token;
import interfaces.MoveFactoryHelper;
import interfaces.ViewManagerHelper;
import javafx.scene.Node;
import managers.viewmanager.GuiComponent;
import managers.viewmanager.ViewManager;
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
        mBoardManager = new BoardManager(5);
        mViewManager = new ViewManager(this);
        mMoveFactory = new MoveFactory(this);
    }

    // MoveFactoryHelper methods
    @Override
    public Request getRequest() {
        return mRequest;
    }
    @Override
    public Token getToken() {
        String id = mRequest.getSquareId();
        int integerId = Integer.getInteger(id);

        return mBoardManager.getTokenBySquareId(integerId);
    }

    @Override
    public Board getBoardMoveFactory() {
        return mBoardManager.getBoard();
    }







    // ViewManagerHelper interface methods
    @Override
    public void requestMove(Request request) {
        mRequest = request;
        System.out.println(request);
    }

    @Override
    public List<GuiComponent> getGuiComponents() {

        Square[][] boardNodes = mBoardManager.getBoard().getBoardState();
        List<GuiComponent> boardGuiComponents = new ArrayList<>();
        int size = mBoardManager.getBoard().getGridSize();

        for(int i = 0; i < size; i ++)
            for(int j = 0; j < size; j ++) {
                boardGuiComponents.add(new GuiComponent(boardNodes[i][j],
                        boardNodes[i][j].getSquareId()));
            }


        List<Square> tokenSquaresGuiComponents = mBoardManager.getOutsideTokensSquare();
        List<GuiComponent> tokensGuiComponents = new ArrayList<>();

        for(Square square : tokenSquaresGuiComponents) {
            tokensGuiComponents.add(new GuiComponent(square, square.getSquareId()));
        }
        List<GuiComponent> allGuiComponents = new ArrayList<>(boardGuiComponents);

        allGuiComponents.addAll(tokensGuiComponents);

        return allGuiComponents;
    }
    @Override
    public int getBoardWidth() {
        return mBoardManager.getBoardWidth();
    }
    @Override
    public Node getBoard() {
        return mBoardManager.getBoard();
    }
    @Override
    public List<Node> getTokens() {
        return new ArrayList<>(mBoardManager.getOutsideTokens());
    }
    @Override
    public List<Node> getFreeCells() {
        return new ArrayList<>(mBoardManager.getFreeCells());
    }

    // this method is called from the main class
    public List<Node> getViewNodes() {
        return mViewManager.updateNodes();
    }
}
