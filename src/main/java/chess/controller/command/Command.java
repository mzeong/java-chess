package chess.controller.command;

import chess.domain.game.Game;
import chess.view.OutputView;

public interface Command {

    void execute(Game game, OutputView outputView);

    boolean isNotEnd();
}
