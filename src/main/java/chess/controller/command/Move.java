package chess.controller.command;

import chess.domain.game.Game;
import chess.domain.position.Position;
import chess.view.OutputView;

public class Move implements Command {

    private final Position source;
    private final Position target;

    public Move(Position source, Position target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public void execute(Game game, OutputView outputView) {
        game.proceedTurn(source, target);
        outputView.printBoard(game.board());
    }

    @Override
    public boolean isNotEnd() {
        return true;
    }
}
