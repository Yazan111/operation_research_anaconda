package interfaces;

import javafx.scene.Node;
import managers.viewmanager.GuiComponent;
import move.Request;

import java.util.List;

public interface ViewManagerHelper {

    void requestMove(Request request);
    List<GuiComponent> getGuiComponents();
    Node getBoard();
    List<Node> getTokens();
    int getBoardWidth();
    List<Node> getFreeCells();

}
