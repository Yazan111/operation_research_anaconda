package move;

import board.Square;
import interfaces.Move;
import javafx.scene.image.Image;

import java.util.*;

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

/*
        if(mSource.getLeftMagnitude() != null)
            System.out.println("left " + mSource.getLeftMagnitude().getSquareId());
        if(mSource.getRightMagnitude() != null)
            System.out.println("right " + mSource.getRightMagnitude().getSquareId());
        if(mSource.getTopMagnitude() != null)
            System.out.println("top " + mSource.getTopMagnitude().getSquareId());
        if(mSource.getDownMagnitude() != null)
            System.out.println("down " + mSource.getDownMagnitude().getSquareId());
        System.out.println("self " + mSource.getSquareId());
*/

        int tokenId = mSource.getTokenId();
        Map<Square, Image> destinationData = getDestinationSquareImageMap(new HashMap<Square, Image>(),
                -1, mSource, mDestination);


        Set<Square> squares = destinationData.keySet();

        for(Square square : squares) {
            Image image = destinationData.get(square);
            square.setImage(image);
            square.setTokenId(tokenId);
        }

    }


    private Map<Square, Image> getDestinationSquareImageMap(Map<Square, Image> map, int lastVisitedSquare,
                                                Square currentSquare,
                                                Square destination) {

        map.put(destination, currentSquare.getImage());
        currentSquare.setImage(null);
        int tokenId = currentSquare.getTokenId();
        currentSquare.setTokenId(-1);

        Square topMagnitude = currentSquare.getTopMagnitude();
        if(topMagnitude != null &&
                topMagnitude.getTokenId() == tokenId &&
                lastVisitedSquare != currentSquare.getSquareId()
        ) {

            getDestinationSquareImageMap(map, currentSquare.getSquareId(), topMagnitude,
                    destination.getTopMagnitude());

        }
        Square leftMagnitude = currentSquare.getLeftMagnitude();
        if(leftMagnitude != null &&
                leftMagnitude.getTokenId() == tokenId &&
                lastVisitedSquare != currentSquare.getSquareId()
        ) {

            getDestinationSquareImageMap(map, currentSquare.getSquareId(), leftMagnitude,
                    destination.getLeftMagnitude());
        }

        Square downMagnitude = currentSquare.getDownMagnitude();
        if(downMagnitude != null &&
                downMagnitude.getTokenId() == tokenId &&
                lastVisitedSquare != currentSquare.getSquareId()) {

            getDestinationSquareImageMap(map, currentSquare.getSquareId(), downMagnitude,
                    destination.getDownMagnitude());
        }

        Square rightMagnitude = currentSquare.getRightMagnitude();
        if(rightMagnitude != null &&
                rightMagnitude.getTokenId() == tokenId &&
                lastVisitedSquare != currentSquare.getSquareId()) {

            getDestinationSquareImageMap(map, currentSquare.getSquareId(), rightMagnitude,
                    destination.getRightMagnitude());
        }
        return map;
    }


}
