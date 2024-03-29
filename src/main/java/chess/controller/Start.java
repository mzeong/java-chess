package chess.controller;

import chess.domain.Game;
import chess.view.OutputView;

public class Start implements Command1 {

    @Override
    public void execute(Game game, OutputView outputView) {
        outputView.printBoard(game.board());
    }

    @Override
    public boolean isNotEnd() {
        return true;
    }
}
