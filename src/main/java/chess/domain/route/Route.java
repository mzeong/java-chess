package chess.domain.route;

import chess.domain.board.Board;
import chess.domain.piece.Side;
import chess.domain.position.Position;
import chess.domain.piece.Piece;
import java.util.List;
import java.util.Objects;

public class Route {

    private final List<Piece> pathPieces;
    private final Piece targetPiece;

    public Route(List<Piece> pathPieces, Piece targetPiece) {
        this.pathPieces = pathPieces;
        this.targetPiece = targetPiece;
    }

    public static Route create(Position source, Position target, Board board) {
        Path path = Path.of(source, target);
        List<Piece> pathPieces = board.findPieces(path);
        Piece targetPiece = board.findPiece(target);
        return new Route(pathPieces, targetPiece);
    }

    public boolean hasNonEmptyPathPieces() {
        return pathPieces.stream()
                .anyMatch(Piece::isNotEmpty);
    }

    public boolean isTargetPieceEmpty() {
        return targetPiece.isEmpty();
    }

    public boolean isAllyTargetPiece(Side side) {
        return targetPiece.isSameSide(side);
    }

    public boolean isOpponentTargetPiece(Side side) {
        return targetPiece.isOpponentSide(side);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Route route = (Route) o;
        return Objects.equals(pathPieces, route.pathPieces) && Objects.equals(targetPiece,
                route.targetPiece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathPieces, targetPiece);
    }
}
