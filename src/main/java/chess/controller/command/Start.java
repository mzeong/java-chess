package chess.controller.command;

import chess.domain.Game;
import chess.view.OutputView;

public class Start implements Command {

    @Override
    public void execute(Game game, OutputView outputView) {
        outputView.printBoard(game.board());
    }

    @Override
    public boolean isNotEnd() {
        return true;
    }
}
