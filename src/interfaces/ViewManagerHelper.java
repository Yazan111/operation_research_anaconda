package interfaces;

import javafx.scene.Node;
import move.Request;

import java.util.List;

public interface ViewManagerHelper {

    void requestMove(Request request);
    Node getBoardNode();
    List<Node> getOutsideTokensNodes();
    List<Node> getFreeCells();
    int getBoardWidth();

}
