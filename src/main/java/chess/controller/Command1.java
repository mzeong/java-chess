package chess.controller;

import chess.domain.Game;
import chess.view.OutputView;

public interface Command1 {

    void execute(Game game, OutputView outputView);

    boolean isNotEnd();
}
