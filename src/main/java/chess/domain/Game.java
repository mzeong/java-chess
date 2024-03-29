package chess.domain;

import chess.domain.board.Board;
import chess.domain.board.BoardCreator;
import chess.domain.board.BoardStatus;
import chess.domain.position.Position;
import chess.domain.piece.Piece;
import java.util.List;

public class Game {

    private final Board board;
    private BoardStatus boardStatus;

    public Game(BoardCreator boardCreator) {
        this.board = Board.from(boardCreator);
        this.boardStatus = boardCreator.createBoardStatus();
    }

    public void proceedTurn(Position source, Position target) {
        checkTurn(source);
        boardStatus = board.move(source, target);
    }

    private void checkTurn(Position source) {
        Piece piece = board.findPiece(source);
        if (boardStatus.isWhiteTurn() && piece.isWhite() || boardStatus.isBlackTurn() && piece.isBlack()) {
            return;
        }
        throw new IllegalArgumentException("해당 진영의 차례가 아닙니다.");
    }

    public boolean isNotKingDead() {
        return !boardStatus.isKingDead();
    }

    public List<Piece> board() {
        return board.pieces();
    }
}
