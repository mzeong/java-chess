package chess.controller.command;

import chess.domain.game.Game;
import chess.domain.game.Score;
import chess.view.OutputView;

public class Status implements Command {

    @Override
    public void execute(Game game, OutputView outputView) {
        Score score = game.calculateScore();
        outputView.printScore(score);
    }

    @Override
    public boolean isNotEnd() {
        return true;
    }
}
