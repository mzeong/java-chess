package chess.domain.game;

import static chess.fixture.PieceFixture.BLACK_KING;
import static chess.fixture.PieceFixture.WHITE_QUEEN;
import static chess.fixture.PositionFixture.A2;
import static chess.fixture.PositionFixture.A3;
import static chess.fixture.PositionFixture.A6;
import static chess.fixture.PositionFixture.A7;
import static chess.fixture.PositionFixture.B2;
import static chess.fixture.PositionFixture.B3;
import static chess.fixture.PositionFixture.E8;
import static chess.fixture.PositionFixture.H5;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.domain.game.GameCreator;
import chess.domain.board.BoardStatus;
import chess.domain.game.InitialGameCreator;
import chess.domain.game.Game;
import chess.domain.piece.Piece;
import chess.domain.position.Position;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    /*
    RNBQKBNR  8
    PPPPPPPP  7
    ........  6
    ........  5
    ........  4
    ........  3
    pppppppp  2
    rnbqkbnr  1

    abcdefgh
     */
    @DisplayName("검은색 진영이 먼저 턴을 진행하면 예외가 발생한다.")
    @Test
    void notProceedBlackTurn() {
        Game game = new Game(new InitialGameCreator());

        assertThatThrownBy(() -> game.proceedTurn(A7, A6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 진영의 차례가 아닙니다.");
    }

    @DisplayName("흰색 진영이 먼저 턴을 진행한다.")
    @Test
    void proceedWhiteTurn() {
        Game game = new Game(new InitialGameCreator());

        assertThatCode(() -> game.proceedTurn(A2, A3))
                .doesNotThrowAnyException();
    }

    /*
    RNBQKBNR  8
    PPPPPPPP  7
    ........  6
    ........  5
    ........  4
    p.......  3
    .ppppppp  2
    rnbqkbnr  1

    abcdefgh
     */
    @DisplayName("흰색 진영 다음에 흰색 진영이 턴을 진행하면 예외가 발생한다.")
    @Test
    void notProceedWhiteTurn() {
        Game game = new Game(new InitialGameCreator());
        game.proceedTurn(A2, A3);

        assertThatThrownBy(() -> game.proceedTurn(B2, B3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 진영의 차례가 아닙니다.");
    }

    @DisplayName("흰색 진영 다음에 검은색 진영이 턴을 진행한다.")
    @Test
    void proceedBlackTurn() {
        Game game = new Game(new InitialGameCreator());
        game.proceedTurn(A2, A3);

        assertThatCode(() -> game.proceedTurn(A7, A6))
                .doesNotThrowAnyException();
    }

    /*
    ....K...  8
    ........  7
    ........  6
    .......q  5
    ........  4
    ........  3
    ........  2
    ........  1

    abcdefgh
     */
    @DisplayName("King을 잡다.")
    @Test
    void catchKing() {
        Game game = new Game(new GameCreator() {
            @Override
            public Map<Position, Piece> createBoard() {
                return new HashMap<>() {{
                    put(E8, BLACK_KING);
                    put(H5, WHITE_QUEEN);
                }};
            }

            @Override
            public BoardStatus createBoardStatus() {
                return BoardStatus.WHITE_TURN;
            }
        });

        game.proceedTurn(H5, E8);

        assertThat(game.isNotKingDead()).isFalse();
    }
}
