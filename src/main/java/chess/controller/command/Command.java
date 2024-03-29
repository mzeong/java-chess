package chess.controller.command;

import chess.domain.Game;
import chess.view.OutputView;

public interface Command {

    void execute(Game game, OutputView outputView);

    boolean isNotEnd();
}
