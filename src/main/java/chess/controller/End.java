package chess.controller;

import chess.domain.Game;
import chess.view.OutputView;

public class End implements Command1 {

    @Override
    public void execute(Game game, OutputView outputView) {
    }

    @Override
    public boolean isNotEnd() {
        return false;
    }
}
