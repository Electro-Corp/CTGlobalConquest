package gd.rf.jsgames.operations;

import gd.rf.jsgames.App;

public class NextTurn extends Action {
    @Override
    public void doAction() {
        App.nextTurn();
    }
}
