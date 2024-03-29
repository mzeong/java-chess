package chess.controller.command;

import chess.domain.game.Game;
import chess.view.OutputView;

public class End implements Command {

    @Override
    public void execute(Game game, OutputView outputView) {
    }

    @Override
    public boolean isNotEnd() {
        return false;
    }
}
