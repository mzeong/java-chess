package chess.domain.board;

import chess.domain.route.Route;
import chess.domain.route.Path;
import chess.domain.route.Pieces;
import chess.domain.position.Position;
import chess.domain.piece.Empty;
import chess.domain.piece.Piece;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Board {

    private final Map<Position, Piece> board;

    public Board(Map<Position, Piece> board) {
        this.board = new LinkedHashMap<>(board);
    }

    public static Board from(BoardCreator boardCreator) {
        return new Board(boardCreator.create());
    }

    public BoardStatus move(Position source, Position target) {
        Piece sourcePiece = findPiece(source);
        Piece targetPiece = findPiece(target);
        Route route = Route.create(source, target, this);
        sourcePiece.checkValidMove(source, target, route);

        board.put(source, Empty.instance());
        board.put(target, sourcePiece);

        return BoardStatus.of(sourcePiece, targetPiece);
    }

    public Piece findPiece(Position position) {
        return board.get(position);
    }

    public Pieces findPieces(Path path) {
        List<Piece> pieces = board.entrySet().stream()
                .filter(entry -> path.contains(entry.getKey()))
                .map(Entry::getValue)
                .toList();

        return new Pieces(pieces);
    }

    public List<Piece> pieces() {
        return board.values().stream()
                .toList();
    }
}
