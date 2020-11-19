package move;

import board.Square;
import interfaces.Move;

public class MoveToken implements Move {
    private Square mSource;
    private Square mDestination;

    public MoveToken(Square source, Square destination)
    {
        mSource = source;
        mDestination = destination;
    }

    @Override
    public void doAction() {
        moveTokens(mSource, mDestination, -1);
    }

    private void moveTokens(Square from, Square to, int lastVisitedId) {
        to.setImage(from.getImage());
        to.setTokenId(from.getTokenId());
        from.setImage(null);
        int tokenId = from.getTokenId();
        from.setTokenId(-1);


        // TODO: move the pic type which will be implemeented later
        if(from.getTopMagnitude() != null &&
                from.getTopMagnitude().getTokenId() == tokenId &&
                from.getTopMagnitude().getSquareId() != lastVisitedId) {
            moveTokens(from.getTopMagnitude(), to.getTopMagnitude(), from.getSquareId());
        }

        if(from.getLeftMagnitude() != null &&
                from.getLeftMagnitude().getTokenId() == tokenId &&
                from.getLeftMagnitude().getSquareId() != lastVisitedId) {
            moveTokens(from.getLeftMagnitude(), to.getLeftMagnitude(), from.getSquareId());
        }

        if(from.getDownMagnitude() != null &&
                from.getDownMagnitude().getTokenId() == tokenId &&
                from.getDownMagnitude().getSquareId() != lastVisitedId) {
            moveTokens(from.getDownMagnitude(), to.getDownMagnitude(), from.getSquareId());
        }

        if(from.getRightMagnitude() != null &&
                from.getRightMagnitude().getTokenId() == tokenId &&
                from.getRightMagnitude().getSquareId() != lastVisitedId) {
            moveTokens(from.getRightMagnitude(), to.getRightMagnitude(), from.getSquareId());
        }
    }


}
