package chess.domain.route;

import chess.domain.board.Board;
import chess.domain.piece.Side;
import chess.domain.position.Position;
import chess.domain.piece.Piece;
import java.util.Objects;

public class Route {

    private final Pieces pathPieces;
    private final Piece targetPiece;

    public Route(Pieces pathPieces, Piece targetPiece) {
        this.pathPieces = pathPieces;
        this.targetPiece = targetPiece;
    }

    public static Route create(Position source, Position target, Board board) {
        Path path = Path.of(source, target);
        Pieces pathPieces = board.findPieces(path);
        Piece targetPiece = board.findPiece(target);
        return new Route(pathPieces, targetPiece);
    }

    //조금 더 쉬운 메서드 명을 지으면 이해하기 편할 것 같아요
    //(개인적 의견) 저는 부정문보다 !긍정문이 더 잘 읽히네요 ^_^
    public boolean notAllPathPiecesEmpty() {
        return pathPieces.notAllEmpty();
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
