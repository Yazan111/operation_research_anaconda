package interfaces;

import board.Board;
import board.token.Token;
import move.Request;

public interface MoveFactoryHelper {
    Request getRequest();
    Token getToken();
    Board getBoardMoveFactory();
}
