package chess.controller;

import chess.domain.Game;
import chess.domain.position.Position;
import chess.view.OutputView;

public class Move implements Command1 {

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
