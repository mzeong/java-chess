package chess.controller;

import chess.controller.command.Command;
import chess.domain.game.Game;
import chess.domain.game.InitialGameCreator;
import chess.view.InputView;
import chess.view.OutputView;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Game game = new Game(new InitialGameCreator());

        Command command = inputView.readFirstCommand();
        command.execute(game, outputView);

        while (command.isNotEnd() && game.isNotKingDead()) {
            command = inputView.readFollowingCommand();
            command.execute(game, outputView);
        }
    }
}
