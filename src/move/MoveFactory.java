package move;

import board.Board;
import board.Square;
import board.token.Token;
import interfaces.Move;
import interfaces.MoveFactoryHelper;

public class MoveFactory {
    private final MoveFactoryHelper mMoveFactoryHelper;

    public MoveFactory(MoveFactoryHelper moveFactoryHelper) {
        this.mMoveFactoryHelper = moveFactoryHelper;
    }

    public Move createMove() {
        Square sourceSquare = mMoveFactoryHelper.getSourceLocation();
        Square targetedSquare = mMoveFactoryHelper.getTargetedLocation();
        String actionName = mMoveFactoryHelper.getActionName();


        Move move = null;

        switch (actionName) {
            case "changeLocation":
                move = new MoveToken(sourceSquare, targetedSquare);
                break;

            case "rotate":

                break;

            case "flip":
                break;
            default:
                return null;
        }

        return move;
    }
}
