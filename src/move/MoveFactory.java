package move;

import interfaces.MoveFactoryHelper;

public class MoveFactory {
    private MoveFactoryHelper mMoveFactoryHelper;

    public MoveFactory(MoveFactoryHelper moveFactoryHelper) {
        this.mMoveFactoryHelper = moveFactoryHelper;
    }
}
