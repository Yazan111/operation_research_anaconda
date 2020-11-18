package managers.viewmanager;

import javafx.scene.Node;

public class GuiComponent {
    Node mNode;
    int mId;

    public GuiComponent(Node node, int id) {
        this.mNode = node;
        this.mId = id;
    }

    public Node getNode() {
        return mNode;
    }

    public int getId() {
        return mId;
    }
}
