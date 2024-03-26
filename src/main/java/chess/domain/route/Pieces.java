package chess.domain.route;

import chess.domain.piece.Piece;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pieces {

    private final List<Piece> pieces;

    // 생성자를 합쳐보아요~
    public Pieces() {
        this.pieces = new ArrayList<>();
    }

    public Pieces(List<Piece> pieces) {
        this.pieces = new ArrayList<>(pieces);
    }

    public boolean notAllEmpty() {
        return pieces.stream()
                .anyMatch(Piece::isNotEmpty);
        // .noneMatch(Piece::isEmpty)도 가능하지 않을까요?
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pieces pieces1 = (Pieces) o;
        return Objects.equals(pieces, pieces1.pieces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieces);
    }
}
