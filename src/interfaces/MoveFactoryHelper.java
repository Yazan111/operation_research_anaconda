package interfaces;

import board.Board;
import board.Square;
import board.token.Token;
import move.Request;

public interface MoveFactoryHelper {
    Square getSourceLocation();
    Square getTargetedLocation();
    String getActionName();
}
