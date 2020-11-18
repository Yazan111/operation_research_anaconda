package managers.viewmanager;

import interfaces.ViewManagerHelper;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.*;
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

    public ViewManager(ViewManagerHelper helper) {

        this.mViewManagerHelper = helper;


        this.mBoardShift = 50;
        this.mTokensShift = getTokensShift();
        this.mTokensShift += 50;
        setupDragAndDropForAllCells();

    }

    private int getTokensShift() {
        int boardWidth = mViewManagerHelper.getBoardWidth();
        boardWidth += mBoardShift;

        return boardWidth;
    }

    public List<Node> updateNodes() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(buildBoardNode());

        if (buildTokensNodes() != null)
            nodes.add(buildTokensNodes());

        return nodes;
    }

    public Node buildBoardNode() {
        Node board = mViewManagerHelper.getBoard();
        board.setLayoutX(mBoardShift);
        board.setLayoutY(mBoardShift);

        return board;
    }

    public Node buildTokensNodes() {
        List<Node> tokensNodes = mViewManagerHelper.getTokens();

        VBox box = new VBox();
        box.getChildren().addAll(tokensNodes);
        box.setLayoutX(mTokensShift);
        box.setLayoutY(mBoardShift);
        box.setSpacing(50);

        return box;
    }

    private void setupDragAndDropForAllCells() {
        List<GuiComponent> components = mViewManagerHelper.getGuiComponents();

        for(GuiComponent source : components) {
            for(GuiComponent target: components) {
                setupDragAndDrop(source, target);
            }
        }

    }


    private void setupDragAndDrop(GuiComponent sourceComponent,
                                  GuiComponent targetComponent) {

        Node source = sourceComponent.getNode();
        Node target = targetComponent.getNode();

        source.setId(Integer.toString(sourceComponent.getId()));
        target.setId(Integer.toString(targetComponent.getId()));

        Request request = new Request();

        source.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int sourceID = sourceComponent.getId();

                Dragboard db = source.startDragAndDrop(TransferMode.COPY_OR_MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(Integer.toString(sourceID));
                db.setContent(content);

                mouseEvent.consume();
            }
        });

        target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {

                if(dragEvent.getGestureSource() != target &&
                        dragEvent.getDragboard().hasString()){
                    dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                dragEvent.consume();
            }
        });

        source.setOnDragDone(event -> {
            /* the drag-and-drop gesture ended */
            /* if the data was successfully moved, clear it */
            if (event.getTransferMode() == TransferMode.MOVE) {
            }
            event.consume();
        });

        target.setOnDragEntered(event -> {
            /* the drag-and-drop gesture entered the target */
            /* show to the user that it is an actual gesture target */
            if (event.getGestureSource() != target && event.getDragboard().hasString()) {
                target.setStyle("-fx-border-color: #090;");
            }
            event.consume();
        });

        target.setOnDragExited(event -> {
            /* mouse moved away, remove the graphical cues */
            target.setStyle("-fx-border-color: #000;");

            event.consume();
        });

        target.setOnDragDropped(event -> {
            String sourceString = "";
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                sourceString = db.getString();
                success = true;
            }

            event.setDropCompleted(success);


            request.setSquareId(sourceString);
            request.setLocation(target.getId());
            request.setRequestName("move");

            mViewManagerHelper.requestMove(request);

            event.consume();
        });
    }

}